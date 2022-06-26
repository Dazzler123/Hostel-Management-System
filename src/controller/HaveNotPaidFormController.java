package controller;

import bo.BOFactory;
import bo.custom.ReportsBO;
import dto.StudentDTO;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.time.LocalDate;

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
        //set today's date
        lblDate.setText(String.valueOf(LocalDate.now()));
    }

    public void btnExit(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
