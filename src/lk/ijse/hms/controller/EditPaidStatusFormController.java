package lk.ijse.hms.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import lk.ijse.hms.bo.BOFactory;
import lk.ijse.hms.bo.custom.ReservationBO;
import lk.ijse.hms.dto.ReserveDTO;

public class EditPaidStatusFormController {
    public TableView<ReserveDTO> tblReserve;
    public TableColumn colResID;
    public TableColumn colDate;
    public TableColumn colStudentID;
    public TableColumn colRoomID;
    public TableColumn colStatus;

    //student's id from search student id option in Registration UI
    static String s_id = null;
    static String status = null;

    //Dependency injection - property injection
    private final ReservationBO reservationBO = (ReservationBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.RESERVE);

    public void initialize(){
        //load all non-paid reservations related to the student
        loadAllReservations();
    }

    private void loadAllReservations() {
        ObservableList<ReserveDTO> reservationList = FXCollections.observableArrayList(reservationBO.getReservations());
        tblReserve.setItems(reservationList);
    }

    public static void setStudentID(String id) {
        s_id = id;
    }

    public void btnUpdatePaidStatus(ActionEvent actionEvent) {
        status = "Paid";

        //set status as paid
        if (!(status == null)){
            //confirmation alert
            new Alert(Alert.AlertType.CONFIRMATION,"Status is set to Paid").show();
        }
    }

    public void btnSave(ActionEvent actionEvent) {
    }

    public void btnExit(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
