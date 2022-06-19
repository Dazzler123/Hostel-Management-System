package controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import util.UINavigation;

import java.io.IOException;

public class UserControlsFormController {

    public void btnToMakeRegistration(ActionEvent actionEvent) throws IOException {
        UINavigation.setUI("RegistrationForm","Make Registration");
    }

    public void btnToManageStudents(ActionEvent actionEvent) throws IOException {
        UINavigation.setUI("ManageStudentsForm","Manage Students");
    }

    public void btnToManageRooms(ActionEvent actionEvent) throws IOException {
        UINavigation.setUI("ManageRoomsForm","Manage Rooms");
    }

    public void btnToEditUnPw(ActionEvent actionEvent) throws IOException {
        UINavigation.setUI("EditUnPwdForm","Edit Username or Password");
    }

    public void btnKeyMoneyNotPaid(ActionEvent actionEvent) {
    }

    public void btnStudentDetails(ActionEvent actionEvent) {
    }

    public void btnExit(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

}
