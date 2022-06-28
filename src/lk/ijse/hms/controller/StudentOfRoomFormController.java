package lk.ijse.hms.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.hms.bo.BOFactory;
import lk.ijse.hms.bo.custom.ReportsBO;
import lk.ijse.hms.dto.StudentDTO;

public class StudentOfRoomFormController {
    public TableView<StudentDTO> tblStudent;
    public TableColumn colID;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContactNo;
    public TableColumn colDOB;
    public TableColumn colGender;
    public JFXTextField txtRoomID;

    //Dependency injection - property injection
    private final ReportsBO reportsBO = (ReportsBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.REPORT);

    public void initialize(){
        colID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("date"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
    }

    public void txtSearchRoom(ActionEvent actionEvent) {
        ObservableList<StudentDTO> obList = FXCollections.observableArrayList(reportsBO.getRooms(txtRoomID.getText()));
        tblStudent.setItems(obList);
    }

    public void btnExit(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
