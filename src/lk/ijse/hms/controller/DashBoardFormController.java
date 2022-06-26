package lk.ijse.hms.controller;

import javafx.event.ActionEvent;
import lk.ijse.hms.util.UINavigation;

import java.io.IOException;

public class DashBoardFormController {
    public void btnToUserLogin(ActionEvent actionEvent) throws IOException {
        UINavigation.setUI("UserLoginForm","User Login");
    }
}
