package lk.ijse.hms.controller;

import lk.ijse.hms.bo.BOFactory;
import lk.ijse.hms.bo.custom.UserLoginBO;
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

    //Dependency injection - property injection
    private final UserLoginBO userLoginBO = (UserLoginBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.USER_CREDENTIALS);

    public void initialize() {
        txtNewUsername.setDisable(true);
        pwdNewPassword.setDisable(true);
    }

    public void btnVerifyCredentials(ActionEvent actionEvent) {
        String un = String.valueOf(txtUsername.getText());
        String pw = String.valueOf(pwdPassword.getText());

        if (un.equals(userLoginBO.getUserName()) & pw.equals(userLoginBO.getPassWord())) {
            //enable textfields to enter new credentials
            txtNewUsername.setDisable(false);
            pwdNewPassword.setDisable(false);
        } else {
            //warning alert
            new Alert(Alert.AlertType.ERROR, "Incorrect Username or Password!").show();
            //refresh textfields
            txtUsername.clear();
            pwdPassword.clear();
        }
    }

    public void btnConfirm(ActionEvent actionEvent) {
        String newUn = String.valueOf(txtNewUsername.getText());
        String newPw = String.valueOf(pwdNewPassword.getText());

        //update user credentials
        if(userLoginBO.updateCredentials(txtUsername.getText(),newUn,newPw)){
            //confirmation alert
            new Alert(Alert.AlertType.CONFIRMATION, "Credentials Confirmed.").show();
        }
    }

    public void btnExit(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

}
