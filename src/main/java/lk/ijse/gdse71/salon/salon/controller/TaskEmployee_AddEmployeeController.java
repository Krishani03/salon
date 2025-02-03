package lk.ijse.gdse71.salon.salon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse71.salon.salon.dto.EmployeeDTO;
import lk.ijse.gdse71.salon.salon.model.EmployeeModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TaskEmployee_AddEmployeeController implements Initializable{

    public Button save_btn;
    @FXML
    private Label employeeID_lbl;

    @FXML
    private TextField EmployeeName_txt;

    @FXML
    private TextField Role_txt;

    @FXML
    private TextField SalonId_txt;

    @FXML
    private AnchorPane addEmployeePane;

    @FXML
    private Button back_btn;

    @FXML
    void BackToTaskEmployee(ActionEvent event) throws IOException {
        addEmployeePane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/DashBoardRecepView.fxml"));
        addEmployeePane.getChildren().add(pane);

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            refreshPage();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Fail to load employee id").show();
        }
    }

    private void refreshPage() throws SQLException {
        loadNextEmployeeId();

        save_btn.setDisable(false);

        EmployeeName_txt.setText("");
        Role_txt.setText("");
        SalonId_txt.setText("");
    }
    EmployeeModel employeeModel = new EmployeeModel();

    private void loadNextEmployeeId() throws SQLException {
        String nextEmployeeId = employeeModel.getNextEmployeeId();
        employeeID_lbl.setText(nextEmployeeId);
    }
    @FXML
    void conform_btn_OnAction(ActionEvent event) throws SQLException {
        String em_id =employeeID_lbl.getText();
        String em_name =EmployeeName_txt.getText();
        String role =Role_txt.getText();
        String salon_id =SalonId_txt.getText();

        EmployeeDTO employeeDTO = new EmployeeDTO(
                em_id,
                em_name,
                role,
                salon_id
        );

        boolean isSaved = employeeModel.saveEmployee(employeeDTO);
        if (isSaved) {
            refreshPage();
            new Alert(Alert.AlertType.INFORMATION, "Employee saved...!").show();

        } else {
            new Alert(Alert.AlertType.ERROR, "Fail to save Employee...!").show();
        }
    }
}

