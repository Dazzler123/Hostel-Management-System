package lk.ijse.hms.controller;

import lk.ijse.hms.bo.BOFactory;
import lk.ijse.hms.bo.custom.NewRoomBO;
import com.jfoenix.controls.JFXTextField;
import lk.ijse.hms.dto.RoomDTO;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class AddNewRoomFormController {
    public JFXTextField txtRoomID;
    public JFXTextField txtRoomType;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtRoomQty;

    //Dependency injection - property injection
    private final NewRoomBO newRoomBO = (NewRoomBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.NEW_ROOM);

    public void btnSave(ActionEvent actionEvent) {
        String id = txtRoomID.getText();
        String type = txtRoomType.getText();
        double keyMoney = Double.parseDouble(txtKeyMoney.getText());
        String qty = txtRoomQty.getText();

        if(newRoomBO.saveRoom(new RoomDTO(id,type,keyMoney,qty))){
            //confirmation alert
            new Alert(Alert.AlertType.CONFIRMATION,"Room saved successfully.").show();
        }
    }

    public void btnExit(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
