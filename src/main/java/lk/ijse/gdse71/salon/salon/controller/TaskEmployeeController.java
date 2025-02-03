package lk.ijse.gdse71.salon.salon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TaskEmployeeController implements Initializable {


    @FXML
    private AnchorPane employeeManagePane;

    @FXML
    private AnchorPane employeeManagementDashboard_panel;

    @FXML
    void goToAddEmployee(ActionEvent event) {
        navigateTo("/view/TaskEmployee_AddEmployeeView.fxml");
    }

    @FXML
    void goToEmployeeDetailView(ActionEvent event) {
        navigateTo("/view/TaskEmployee_DetailsView.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        navigateTo("/view/TaskEmployee_AddEmployeeView.fxml");
    }

    private void navigateTo(String fxmlPath) {
        try {
            employeeManagementDashboard_panel.getChildren().clear();
            AnchorPane load = FXMLLoader.load(getClass().getResource(fxmlPath));
            employeeManagementDashboard_panel.getChildren().add(load);
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Fail to load page!").show();
        }
    }

    public void goToTaskManager(ActionEvent event) throws IOException {
        employeeManagePane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/DashBoardManagerView.fxml"));
        employeeManagePane.getChildren().add(pane);
    }
}
