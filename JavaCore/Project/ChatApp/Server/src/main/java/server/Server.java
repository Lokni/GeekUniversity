package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

public class Server {
    private static final Logger logger = Logger.getLogger(Server.class.getName());
    private List<ClientHandler> clients;
    private AuthService authService;
    private ServerSocket server;
    private Socket socket;
    private final int PORT = 5000;

    public Server() {
        try {
            server = new ServerSocket(PORT);
            clients = new CopyOnWriteArrayList<>();
            authService = new DBauthService();
            logger.info("Server ready!");
            while (true) {
                try {
                    socket = server.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                new ClientHandler(socket, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadcastMsg(ClientHandler sender, String msg) {
        String message = String.format("[%s]: %s", sender.getNickname(), msg);
        for (ClientHandler c : clients) {
            c.sendMsg(message);
            DBauthService.messageLogInDB(sender.getNickname(), "null", msg, Date.valueOf(LocalDate.now()));
        }
    }

    public void privateMsg(ClientHandler sender, String recipient, String message) {
        for (ClientHandler c : clients) {
            if (c.getNickname().equalsIgnoreCase(recipient)) {
                c.sendMsg("Private message from " + sender.getNickname() + ": " + message);
                sender.sendMsg("Private message to user " + recipient + ": " + message);
                DBauthService.messageLogInDB(sender.getNickname(), recipient, message, Date.valueOf(LocalDate.now()));
                return;
            }
        }
        sender.sendMsg(String.format("Client %s not found", recipient));
    }

    public void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
        clientListViewer();
    }

    public void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
        clientListViewer();
    }

    public AuthService getAuthService() {
        return authService;
    }

    public boolean isLoginAuthenticated(String login) {
        for (ClientHandler c : clients) {
            if (c.getLogin().equalsIgnoreCase(login)) {
                return true;
            }
        }
        return false;
    }

    public void clientListViewer() {
        StringBuilder sb = new StringBuilder("/clientList ");

        for (ClientHandler c : clients) {
            sb.append(c.getNickname()).append(" ");
        }

        String msg = sb.toString();
        for (ClientHandler c : clients) {
            c.sendMsg(msg);
        }
    }
}
