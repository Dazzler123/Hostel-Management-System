package controller;

import bo.custom.SaveStudentBO;
import bo.custom.impl.SaveStudentBOImpl;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.time.LocalDate;

public class AddNewStudentFormController {
    public JFXTextField txtStudentID;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtContactNo;
    public JFXComboBox cbxGender;
    public JFXDatePicker dateOfBirth;

    //Dependency injection - property injection
    private final SaveStudentBO saveStudentBO = new SaveStudentBOImpl();

    public void initialize(){
        //set gender types to combobox
        ObservableList<String> genderList = FXCollections.observableArrayList("Male","Female","Other");
        cbxGender.setItems(genderList);

    }

    public void btnSave(ActionEvent actionEvent) {
        String id = String.valueOf(txtStudentID.getText());
        String name = String.valueOf(txtName.getText());
        String address = String.valueOf(txtAddress.getText());
        String contactNo = String.valueOf(txtContactNo.getText());
        LocalDate dob = dateOfBirth.getValue();
        String gender = String.valueOf(cbxGender.getSelectionModel().getSelectedItem());

        if(saveStudentBO.saveStudent(new StudentDTO(id,name,address,contactNo,dob,gender))){
            //confirmation alert
            new Alert(Alert.AlertType.CONFIRMATION,"Student saved.").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Failed!").show();
        }
    }

    public void btnExit(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
