package controller;

import bo.custom.ManageStudentBO;
import bo.custom.impl.ManageStudentBOImpl;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import util.UINavigation;

import java.io.IOException;

public class ManageStudentsFormController {
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtContactNo;
    public JFXDatePicker dateOfBirth;
    public JFXComboBox cbxGender;
    public TableView<StudentDTO> tblStudent;
    public TableColumn colID;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContactNo;
    public TableColumn colDOB;
    public TableColumn colGender;

    //Dependency injection - property injection
    ManageStudentBO manageStudentBO = new ManageStudentBOImpl();

    public void initialize(){
        //load gender types to combobox
        ObservableList<String> genderList = FXCollections.observableArrayList("Male","Female","Other");
        cbxGender.setItems(genderList);

        //load all students to the table
        loadAllStudents();

    }

    private void loadAllStudents() {
        ObservableList<StudentDTO> studentList = FXCollections.observableArrayList(manageStudentBO.loadAll());
        tblStudent.setItems(studentList);
    }

    public void txtSearchStudent(ActionEvent actionEvent) {
    }

    public void btnAddNewStudent(ActionEvent actionEvent) throws IOException {
        //to add new student form
        UINavigation.setUI("AddNewStudentForm","Add New Student");
    }

    public void btnUpdateStudent(ActionEvent actionEvent) {
    }

    public void btnDeleteStudent(ActionEvent actionEvent) {
    }

    public void btnConfirm(ActionEvent actionEvent) {
    }

    public void btnExit(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

}
