package lk.ijse.hms.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lk.ijse.hms.bo.BOFactory;
import lk.ijse.hms.bo.custom.ReportsBO;

public class StudentOfRoomFormController {
    public TableView tblStudent;
    public TableColumn colID;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContactNo;
    public TableColumn colDOB;
    public TableColumn colGender;
    public JFXTextField txtRoomID;

    //Dependency injection - property injection
    private final ReportsBO reportsBO = (ReportsBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.REPORT);

    public void txtSearchRoom(ActionEvent actionEvent) {
        reportsBO.getRooms(txtRoomID.getText());
    }

    public void btnExit(ActionEvent actionEvent) {
    }
}
