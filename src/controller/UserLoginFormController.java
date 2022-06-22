package controller;

import bo.custom.UserLoginBO;
import bo.custom.impl.UserLoginBOImpl;
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

    //Dependency injection - property injection
    UserLoginBO userLoginBO = new UserLoginBOImpl();

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
         String un = String.valueOf(txtUsername.getText());
         String pw = String.valueOf(pwdPassword.getText());

         if(un.equals(userLoginBO.getUserName()) & pw.equals(userLoginBO.getPassWord())){
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
