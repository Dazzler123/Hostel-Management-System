package controller;

import bo.custom.ManageRoomBO;
import bo.custom.impl.ManageRoomBOImpl;
import com.jfoenix.controls.JFXTextField;
import dto.RoomDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import util.UINavigation;

import java.io.IOException;

public class ManageRoomsFormController {

    public TableView<RoomDTO> tblRooms;
    public TableColumn colRoomID;
    public TableColumn colType;
    public TableColumn colKeyMoney;
    public TableColumn colQty;
    public JFXTextField txtRoomType;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtRoomQty;
    public JFXTextField txtRoomID;

    //Dependency injection - property injection
    ManageRoomBO manageRoomBO = new ManageRoomBOImpl();

    public void initialize() {
        colRoomID.setCellValueFactory(new PropertyValueFactory<>("roomID"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));

        //load all rooms
        loadAllRooms();
    }

    private void loadAllRooms() {
        ObservableList<RoomDTO> roomList = FXCollections.observableArrayList(manageRoomBO.loadAll());
        tblRooms.setItems(roomList);
    }

    public void txtSearchRoom(ActionEvent actionEvent) {
        String id = txtRoomID.getText();
        RoomDTO roomDTO = manageRoomBO.getRoom(id);

        if (!(roomDTO == null)) {
            //set details to textfields
            txtRoomType.setText(roomDTO.getType());
            txtKeyMoney.setText(String.valueOf(roomDTO.getKeyMoney()));
            txtRoomQty.setText(roomDTO.getQty());

            //disable room id input field for no later changes
            txtRoomID.setDisable(true);
        } else {
            new Alert(Alert.AlertType.ERROR, "No such room found with " + txtRoomID.getText() + " ID!").show();
        }
    }

    public void btnAddNewRoom(ActionEvent actionEvent) throws IOException {
        //to add new room ui
        UINavigation.setUI("AddNewRoomForm","Add New Room");
    }

    public void btnUpdateRoom(ActionEvent actionEvent) {
        String id = txtRoomID.getText();
        String type = txtRoomType.getText();
        double keyMoney = Double.parseDouble(txtKeyMoney.getText());
        String qty = txtRoomQty.getText();

        if(manageRoomBO.updateRoom(new RoomDTO(id,type,keyMoney,qty))){
            //confirmation alert
            new Alert(Alert.AlertType.CONFIRMATION,"Room details updated.").show();

            //refresh table
            loadAllRooms();
        }else{
            new Alert(Alert.AlertType.ERROR,"Something went wrong.").show();
        }
    }

    public void btnDeleteRoom(ActionEvent actionEvent) {
        String id = txtRoomID.getText();
        if(manageRoomBO.deleteRoom(id)){
            //confirmation alert
            new Alert(Alert.AlertType.CONFIRMATION,"Room deleted.").show();

            //refresh table
            loadAllRooms();
        }else{
            new Alert(Alert.AlertType.ERROR,"Something went wrong.").show();
        }
    }

    public void btnExit(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
