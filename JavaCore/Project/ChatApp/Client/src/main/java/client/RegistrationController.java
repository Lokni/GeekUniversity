package client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RegistrationController {
    @FXML
    public TextField regLoginField;
    @FXML
    public PasswordField regPasswordField;
    @FXML
    public TextField regNickField;
    @FXML
    public TextArea regTextArea;
    @FXML
    public Button sendRegFormBtn;

    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void clickToRegistration(ActionEvent actionEvent) {
        String login = regLoginField.getText().trim();
        String password = regPasswordField.getText().trim();
        String nickname = regNickField.getText().trim();
        controller.tryToReg(login, password, nickname);
    }

    public void setRegTextArea (String msg){
        regTextArea.appendText(msg + "\n");
    }
}
