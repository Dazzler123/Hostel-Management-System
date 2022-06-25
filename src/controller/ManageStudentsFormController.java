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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import util.UINavigation;

import java.io.IOException;
import java.time.LocalDate;

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
    public JFXTextField txtStudentID;

    //Dependency injection - property injection
    ManageStudentBO manageStudentBO = new ManageStudentBOImpl();

    public void initialize() {
        colID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("date"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        //load gender types to combobox
        ObservableList<String> genderList = FXCollections.observableArrayList("Male", "Female", "Other");
        cbxGender.setItems(genderList);

        //load all students to the table
        loadAllStudents();

    }

    private void loadAllStudents() {
        ObservableList<StudentDTO> studentList = FXCollections.observableArrayList(manageStudentBO.loadAll());
        tblStudent.setItems(studentList);
    }

    public void txtSearchStudent(ActionEvent actionEvent) {
        String id = String.valueOf(txtStudentID.getText());
        StudentDTO studentDTO = manageStudentBO.searchStudent(id);

        if (!(studentDTO == null)) {
            //set student's details to textfields
            txtName.setText(studentDTO.getName());
            txtAddress.setText(studentDTO.getAddress());
            txtContactNo.setText(studentDTO.getContactNo());
            dateOfBirth.setValue(studentDTO.getDate());
            cbxGender.setValue(studentDTO.getGender());

            //disable student id input field for no later changes
            txtStudentID.setDisable(true);
        } else {
            new Alert(Alert.AlertType.ERROR, "No student details found related to " + txtStudentID.getText() + " ID!").show();
        }
    }

    public void btnAddNewStudent(ActionEvent actionEvent) throws IOException {
        //to add new student form
        UINavigation.setUI("AddNewStudentForm", "Add New Student");
    }

    public void btnUpdateStudent(ActionEvent actionEvent) {
        String id = String.valueOf(txtStudentID.getText());
        String name = String.valueOf(txtName.getText());
        String address = String.valueOf(txtAddress.getText());
        String contactNo = String.valueOf(txtContactNo.getText());
        LocalDate dob = dateOfBirth.getValue();
        String gender = String.valueOf(cbxGender.getSelectionModel().getSelectedItem());

        if(manageStudentBO.updateStudentDetails(new StudentDTO(id,name,address,contactNo,dob,gender))){
            //confirmation alert
            new Alert(Alert.AlertType.CONFIRMATION,id+" Student's details updated.").show();

            //refresh table
            loadAllStudents();
        }
    }

    public void btnDeleteStudent(ActionEvent actionEvent) {
        String id = txtStudentID.getText();
        if(manageStudentBO.deleteStudent(id)){
            //confirmation alert
            new Alert(Alert.AlertType.CONFIRMATION,"Student deleted.").show();
        }
    }

    public void btnExit(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

}
