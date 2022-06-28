package lk.ijse.hms.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hms.bo.BOFactory;
import lk.ijse.hms.bo.custom.ReportsBO;
import lk.ijse.hms.dto.ReserveDTO;
import lk.ijse.hms.dto.StudentDTO;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;

public class HaveNotPaidFormController {
    public TableView<StudentDTO> tblStudent;
    public TableColumn colID;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContactNo;
    public TableColumn colDOB;
    public TableColumn colGender;
    public Label lblDate;

    //Dependency injection - property injection
    private final ReportsBO reportsBO = (ReportsBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.REPORT);

    public void initialize(){
        colID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("date"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        //set today's date
        lblDate.setText(String.valueOf(LocalDate.now()));

        //load all student details
        loadAllStudents();
    }

    private void loadAllStudents() {
        ArrayList<ReserveDTO> reserveList = reportsBO.getReservation();
        ArrayList<StudentDTO> studentList = new ArrayList<>();
        for(ReserveDTO r : reserveList){
            studentList.add(reportsBO.getStudent(r.getStudentID()));
        }

        //set students details to the table
        ObservableList<StudentDTO> students = FXCollections.observableArrayList(studentList);
        tblStudent.setItems(students);
    }


    public void btnExit(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
