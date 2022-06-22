package controller;

import bo.custom.RegistrationBO;
import bo.custom.impl.RegistrationBOImpl;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import dto.ReserveDTO;
import dto.RoomDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import util.UINavigation;

import java.io.IOException;
import java.time.LocalDate;

public class RegistrationFormController {
    public TableView<RoomDTO> tblRooms;
    public TableColumn colRoomID;
    public TableColumn colType;
    public TableColumn colKeyMoney;
    public TableColumn colQty;
    public JFXTextField txtStudentID;
    public JFXRadioButton rdBtnPayNow;
    public JFXRadioButton rdBtnPayLater;
    public Label lblName;

    //Dependency injection - property injection
    RegistrationBO registrationBO = new RegistrationBOImpl();

    public void initialize() {
        colRoomID.setCellValueFactory(new PropertyValueFactory<>("roomID"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));

        //load all rooms
        loadAllRooms();
    }

    private void loadAllRooms() {
        ObservableList<RoomDTO> roomList = FXCollections.observableArrayList();
        for (RoomDTO roomDTO : registrationBO.getAllRooms()) {
            roomList.add(new RoomDTO(roomDTO.getRoomID(), roomDTO.getType(), roomDTO.getKeyMoney(), roomDTO.getQty()));
        }
        tblRooms.setItems(roomList);
    }


    public void txtSearchStudent(ActionEvent actionEvent) {
        String id = String.valueOf(txtStudentID.getText());
        if (registrationBO.searchStudent(id)) {

//            ArrayList<String> name = registrationBO.getStudentName(id);
//            lblName.setText(name.get(1));

            //confirmation alert
            new Alert(Alert.AlertType.CONFIRMATION, "Student already exists.").show();

            //disable id textfield for no later changes
            txtStudentID.setDisable(true);
        } else {
            new Alert(Alert.AlertType.ERROR, "No related Student ID found!\nPlease add a new Student").show();
        }
    }

    public void btnAddNewStudent(ActionEvent actionEvent) throws IOException {
        UINavigation.setUI("AddNewStudentForm", "Add New Student");
    }

    public void btnRegister(ActionEvent actionEvent) {
        //get new reservation id
        String resID = registrationBO.generateID();

        RoomDTO selectedRoom = tblRooms.getSelectionModel().getSelectedItem();
        String studentID = String.valueOf(txtStudentID.getText());
        String status = null;

        //get selection from pay now/pay later
        if (rdBtnPayNow.isSelected()) {
            status = "Paid";
        } else if (rdBtnPayLater.isSelected()) {
            status = "Not Paid Yet";
        } else {
            status = "Not Specified";
        }

        //place reservation
        if(registrationBO.register(new ReserveDTO(resID, LocalDate.now(), studentID, selectedRoom.getRoomID(), status))){
            //confirmation alert
            new Alert(Alert.AlertType.CONFIRMATION,"Reservation Placed successfully.").show();
        }

        //room qty should be reduced here...
        //code here
        int roomQty = Integer.parseInt(selectedRoom.getQty());
        int newQty = roomQty - 1;

    }

    public void btnExit(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
