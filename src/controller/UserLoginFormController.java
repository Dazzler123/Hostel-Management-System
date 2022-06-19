package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import util.UINavigation;

import java.io.IOException;

public class UserLoginFormController {
    public JFXTextField txtUsername;
    public JFXPasswordField pwdPassword;

    //username
    static String username = "user";
    //password
    static String password = "1234";

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
         String un = String.valueOf(txtUsername.getText());
         String pw = String.valueOf(pwdPassword.getText());

         if(un.equals(username) & pw.equals(password)){
             UINavigation.setUI("UserControlsForm","User Controls");
             //close login ui
             Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
             stage.close();
         }else{
             new Alert(Alert.AlertType.WARNING,"Incorrect Username or Password!").show();
             //clear textfields
             txtUsername.clear();
             pwdPassword.clear();
         }
    }

    public void btnExit(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
