package controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import util.UINavigation;

import java.io.IOException;

public class UserControlsFormController {
    public void btnEditUnPw(ActionEvent actionEvent) throws IOException {
        UINavigation.setUI("EditUnPwdForm","Edit Username or Password");
    }

    public void btnExit(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
