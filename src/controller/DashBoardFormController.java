package controller;

import javafx.event.ActionEvent;
import util.UINavigation;

import java.io.IOException;

public class DashBoardFormController {
    public void btnToUserLogin(ActionEvent actionEvent) throws IOException {
        UINavigation.setUI("UserLoginForm","User Login");
    }
}
