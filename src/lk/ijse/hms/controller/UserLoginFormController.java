package lk.ijse.hms.controller;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import lk.ijse.hms.bo.BOFactory;
import lk.ijse.hms.bo.custom.UserLoginBO;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import lk.ijse.hms.util.UINavigation;

import java.io.IOException;

public class UserLoginFormController {
    public JFXTextField txtUsername;
    public JFXPasswordField pwdPassword;
    public Label lblPw;
    public CheckBox chkBxShowPassword;

    //Dependency injection - property injection
    UserLoginBO userLoginBO = (UserLoginBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.USER_CREDENTIALS);

    public void initialize(){
        //show password
        chkBxShowPassword.selectedProperty().addListener((observable, oldValue, newValue) -> {
            //show password in the label
            if(!chkBxShowPassword.isSelected()){
                lblPw.setText(null);
            }else {
                String pw = pwdPassword.getText();
                lblPw.setText(pw);
            }
        });

    }

    public void chkBxShowPassword(ActionEvent actionEvent) {
    }

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
