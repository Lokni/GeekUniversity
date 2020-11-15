package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ClientHandler {
    private static final Logger logger = Logger.getLogger(ClientHandler.class.getName());
    private DataInputStream in;
    private DataOutputStream out;
    private String message;
    private Socket socket;
    private Server server;
    private String nickname;
    private String login;
    private boolean disconnect = false;

    public ClientHandler(Socket socket, Server server) {
        try {
            this.socket = socket;
            this.server = server;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            out.flush();
            logger.info(socket.getRemoteSocketAddress() + " client " + nickname + " connected.");

            new Thread(() -> {
                try {
                    socket.setSoTimeout(120_000);

                    // Authentication cycle.
                    while (true) {
                        message = in.readUTF();
                        if (message.equalsIgnoreCase("/end")) {
                            disconnect = true;
                            break;
                        }
                        if (message.startsWith("/reg ")) {
                            String[] token = message.split("\\s");
                            if (token.length != 4) {
                                continue;
                            }
                            boolean b = server.getAuthService()
                                    .registration(token[1], token[2], token[3]);
                            if (b) {
                                sendMsg("/regOk");
                            } else {
                                sendMsg("/regNo");
                            }
                        }
                        if (message.startsWith("/auth ")) {
                            String[] token = message.split("\\s");
                            if (token.length < 3) {
                                continue;
                            }
                            String newNick = server.getAuthService()
                                    .getNicknameByLoginAndPassword(token[1], token[2]);

                            if (newNick != null) {
                                login = token[1];
                                if (!server.isLoginAuthenticated(login)) {
                                    nickname = newNick;
                                    sendMsg("/authok " + newNick + " " + login);
                                    server.subscribe(this);
                                    socket.setSoTimeout(0);
//                                    sendMsg(DBauthService.chatHistory(nickname));
                                    break;
                                } else if (server.isLoginAuthenticated(login)) {
                                    sendMsg("This user is already online.\n");
                                }
                            } else {
                                sendMsg("Wrong login or password.\n");
                            }

                        }
                    }
                    // Messaging cycle.
                    while (true) {
                        try {
                            message = in.readUTF();
                        } catch (EOFException e) {
                            e.printStackTrace();
                        }


                        if (message.startsWith("/")) {
                            if (message.equalsIgnoreCase("/end") || disconnect) {
                                sendMsg("/end");
                                break;
                            }
                            if (message.startsWith("/w ")) {
                                String[] tokens = message.split("\\s", 3);
                                if (tokens.length < 3) {
                                    continue;
                                }
                                String nick = tokens[1];
                                String msg = tokens[2];
                                server.privateMsg(this, nick, msg);
                            }
                            if (message.startsWith("/changeNick")) {
                                String[] token = message.split("\\s", 2);
                                if (token.length < 2) {
                                    continue;
                                }
                                if (token[1].contains(" ")) {
                                    sendMsg("/nochanged");
                                    sendMsg("Nick can't contains spaces");
                                    continue;
                                }
                                if (server.getAuthService().changeNick(this.nickname, token[1])) {
                                    sendMsg("/changed");
                                    this.nickname = token[1];
                                    sendMsg(String.format("/newnick %s", nickname));
                                    server.clientListViewer();

                                } else {
                                    sendMsg("/nochanged");
                                }
                                logger.config(message);
                            }
                            continue;
                        }
                        server.broadcastMsg(this, message);
                    }

                } catch (SocketTimeoutException e) {
                    sendMsg("/end");
                } catch (IOException | SQLException e) {
                    e.printStackTrace();
                } finally {
                    server.unsubscribe(this);
                    logger.info(socket.getRemoteSocketAddress() + " client " + nickname + " disconnected.");
                    try {
                        socket.close();
                        in.close();
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNickname() {
        return nickname;
    }

    public String getLogin() {
        return login;
    }
}
