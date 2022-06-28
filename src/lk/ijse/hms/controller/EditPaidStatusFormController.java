package lk.ijse.hms.controller;

import com.jfoenix.controls.JFXRadioButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    public JFXRadioButton rdBtnPayNow;
    public JFXRadioButton rdBtnPayLater;

    //set status
    static String status = null;

    //Dependency injection - property injection
    private final ReservationBO reservationBO = (ReservationBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.RESERVE);

    public void initialize(){
        colResID.setCellValueFactory(new PropertyValueFactory<>("resID"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colStudentID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        colRoomID.setCellValueFactory(new PropertyValueFactory<>("roomTypeID"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        //get student's id
        setStudentID();

        //load all non-paid reservations related to the student
        loadAllReservations(setStudentID());
    }

    private String setStudentID() {
        return RegistrationFormController.getStudentID();
    }

    private void loadAllReservations(String id) {
        ObservableList<ReserveDTO> reservationList = FXCollections.observableArrayList(reservationBO.getReservations(id));
        tblReserve.setItems(reservationList);
    }

    public void btnSave(ActionEvent actionEvent) {
        ReserveDTO selectedItem = tblReserve.getSelectionModel().getSelectedItem();

        //get selection from pay now/pay later
        if(rdBtnPayNow.isSelected()){
            status = "Paid";
        } else if (rdBtnPayLater.isSelected()) {
            status = "Not Paid";
        }

        //update reservation
        if(reservationBO.updatePaidStatus(selectedItem.getStudentID(),selectedItem.getResID(),status)){
            //confirmation alert
            new Alert(Alert.AlertType.CONFIRMATION,"Paid status updated.").show();

            //refresh status column
            selectedItem.setStatus(status);
            tblReserve.refresh();
        }else{
            new Alert(Alert.AlertType.ERROR,"Something went wrong!").show();
        }
    }

    public void btnExit(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
