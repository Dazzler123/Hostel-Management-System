package controller;

import bo.custom.RegistrationBO;
import bo.custom.impl.RegistrationBOImpl;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import util.UINavigation;

import java.io.IOException;

public class RegistrationFormController {
    public TableView tblRooms;
    public TableColumn colRoomID;
    public TableColumn colType;
    public TableColumn colKeyMoney;
    public TableColumn colQty;
    public JFXTextField txtStudentID;
    public JFXRadioButton rdBtnPayNow;
    public JFXRadioButton rdBtnPayLater;

    //Dependency injection - property injection
    RegistrationBO registrationBO = new RegistrationBOImpl();

    public void initialize(){
        //load all rooms
        loadAllRooms();
    }

    private void loadAllRooms() {
        registrationBO.getAll();
    }


    public void txtSearchStudent(ActionEvent actionEvent) {
    }

    public void btnAddNewStudent(ActionEvent actionEvent) throws IOException {
        UINavigation.setUI("AddNewStudentForm","Add New Student");
    }

    public void btnRegister(ActionEvent actionEvent) {
    }

    public void btnExit(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
