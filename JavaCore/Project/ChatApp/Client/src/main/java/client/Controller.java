package client;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public static final String CHAT_NAME = "Talking Room";
    @FXML
    public ListView<String> clientList;
    @FXML
    public Button regBtn;
    @FXML
    private TextArea textArea;
    @FXML
    private TextField textField;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private HBox authPanel;
    @FXML
    private HBox msgPanel;
    private final String IP_ADDRESS = "localhost";
    private final int PORT = 5000;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String message;
    private boolean authenticated;
    private String nickname;
    private String login;
    private Stage stage;
    private Stage regStage;
    private RegistrationController registrationController;
    private boolean disconnect = false;

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
        authPanel.setVisible(!authenticated);
        authPanel.setManaged(!authenticated);
        msgPanel.setVisible(authenticated);
        msgPanel.setManaged(authenticated);
        clientList.setVisible(authenticated);
        clientList.setManaged(authenticated);

        if (!authenticated) {
            nickname = "";
            Platform.runLater(() -> {
                setTitle(CHAT_NAME);
                History.stop();
            });

        } else {
            Platform.runLater(() -> {
                setTitle(String.format("[%s] - %s", nickname, CHAT_NAME));
            });
        }

        textArea.clear();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            stage = (Stage) textField.getScene().getWindow();
            stage.setOnCloseRequest(event -> {
                if (socket != null && !socket.isClosed()) {
                    try {
                        out.writeUTF("/end");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        });
        setAuthenticated(false);
        registrationWindow();

    }

    public void sendMsg(ActionEvent actionEvent) {
        if (textField.getText().trim().length() == 0) {
            return;
        }
        try {
            out.writeUTF(textField.getText());
            textField.requestFocus();
            textField.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tryToAuth(ActionEvent actionEvent) {
        if (socket == null || socket.isClosed()) {
            connect();
        }
        try {
            String auth = String.format("/auth %s %s", loginField.getText().trim(), passwordField.getText().trim());
            out.writeUTF(auth);
            passwordField.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void connect() {
        try {
            socket = new Socket(IP_ADDRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

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
                        if (message.startsWith("/authok ")) {
                            nickname = message.split("\\s")[1];
                            login = message.split("\\s")[2];
                            setAuthenticated(true);
                            socket.setSoTimeout(0);

                            textArea.appendText(History.getHistory(login));
                            History.start(login);
                            break;
                        } else {
                            textArea.appendText(message);
                        }
                        if (message.startsWith("/regOK ")) {
                            registrationController.setRegTextArea("Registration completed.");
                        }
                        if (message.startsWith("/regNo")) {
                            registrationController.setRegTextArea("Login or nickname already use.");
                        }
                    }
                    // Messaging cycle.
                    while (true) {
                        try {
                            message = in.readUTF();
                        } catch (EOFException e) {
                            textArea.appendText("Socket was closed\n");
                            break;
                        }

                        if (message.startsWith("/")) {
                            if (disconnect || message.equalsIgnoreCase("/end")) {
                                break;
                            }
                            if (message.startsWith("/clientList")) {
                                String[] token = message.split("\\s");
                                Platform.runLater(() -> {
                                    clientList.getItems().clear();
                                    for (int i = 1; i < token.length; i++) {
                                        clientList.getItems().add(token[i]);
                                    }
                                });
                            }
                            if (message.startsWith("/changed")) {
                                textArea.appendText("Your nick was changed.\n");
                            }
                            if (message.startsWith("/nochanged")) {
                                textArea.appendText("This nickname is already exists, or contains spaces");
                            }
                            if (message.startsWith("/newnick ")) {
                                nickname = message.split("\\s", 2)[1];
                                Platform.runLater(() -> setTitle(String.format("[%s] - %s", nickname, CHAT_NAME)));
                            }
//
                        } else {
                            textArea.appendText(message + "\n");
                            History.writeHistory(message);

                        }


                    }
                } catch (SocketTimeoutException e) {
                    textArea.appendText("Socket was closed\n");
                } catch (NullPointerException | IOException e) {
                    e.printStackTrace();
                } finally {
                    setAuthenticated(false);
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

    private void setTitle(String title) {
        Platform.runLater(() -> stage.setTitle(title));
    }

    public void privateMsgTo(MouseEvent mouseEvent) {
        try {
            if (clientList.getSelectionModel().getSelectedItem() != null) {
                textField.setText(String.format("/w %s ", clientList.getSelectionModel().getSelectedItem()));
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


    }

    public void openRegWindow(ActionEvent actionEvent) {
        regStage.show();
    }

    private void registrationWindow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/registrationWindow.fxml"));
            Parent root = fxmlLoader.load();
            regStage = new Stage();
            regStage.setTitle("Registration");
            regStage.setScene(new Scene(root, 250, 350));
            regStage.initModality(Modality.APPLICATION_MODAL);
            registrationController = fxmlLoader.getController();
            registrationController.setController(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void tryToReg(String login, String password, String nickname) {
        try {
            if (socket == null || socket.isClosed()) {
                connect();
            }
            String msg = String.format("/reg %s %s %s", login, password, nickname);
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
