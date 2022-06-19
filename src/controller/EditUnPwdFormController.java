package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class EditUnPwdFormController {

    public JFXTextField txtUsername;
    public JFXPasswordField pwdPassword;
    public JFXTextField txtNewUsername;
    public JFXPasswordField pwdNewPassword;

    public void initialize() {
        txtNewUsername.setDisable(true);
        pwdNewPassword.setDisable(true);
    }

    public void btnVerifyCredentials(ActionEvent actionEvent) {
        String un = UserLoginFormController.username;
        String pw = UserLoginFormController.password;

        if (un.equals(txtUsername.getText()) & pw.equals(pwdPassword.getText())) {
            //enable textfields to enter new credentials
            txtNewUsername.setDisable(false);
            pwdNewPassword.setDisable(false);
        } else {
            //warning alert
            new Alert(Alert.AlertType.ERROR, "Incorrect Username or Password!").show();
        }
    }

    public void btnConfirm(ActionEvent actionEvent) {
        String newUn = String.valueOf(txtNewUsername.getText());
        String newPw = String.valueOf(pwdNewPassword.getText());

        //edit existing credentials
        UserLoginFormController.username = newUn;
        UserLoginFormController.password = newPw;

        //confirmation alert
        new Alert(Alert.AlertType.CONFIRMATION, "Credentials Confirmed.").show();
    }

    public void btnExit(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

}
