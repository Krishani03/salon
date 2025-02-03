package lk.ijse.gdse71.salon.salon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse71.salon.salon.db.DBConnection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static net.sf.jasperreports.engine.JasperCompileManager.compileReport;

public class DashBoardManagerController {

    @FXML
    private AnchorPane ManagerDashBoard_AnchorPanel;

    @FXML
    private Button Notification_btn;

    @FXML
    private Button SalonInsight_btn;

    @FXML
    private Button back_btn;

    @FXML
    private Button employeeDetail_Btn;

    @FXML
    private Button inventoryManagement_btn;

    @FXML
    void back_btn_NavigateOnAction(ActionEvent event) {
        navigateTo("/view/LoginManagerView.fxml");
    }


    private void navigateTo(String fxmlPath) {
        try {
            ManagerDashBoard_AnchorPanel.getChildren().clear();
            AnchorPane load = FXMLLoader.load(getClass().getResource(fxmlPath));
            load.prefWidthProperty().bind(ManagerDashBoard_AnchorPanel.widthProperty());
            load.prefHeightProperty().bind(ManagerDashBoard_AnchorPanel.heightProperty());
            ManagerDashBoard_AnchorPanel.getChildren().add(load);
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Fail to load page!").show();
        }
    }

//    @FXML
//    void CustomerReport_btn_NavigateOnAction(ActionEvent event) {
//        navigateTo("/view/LoginManagerView.fxml");
//    }

    @FXML
    void employeeDetail_Btn_NavigateOnAction(ActionEvent event) {
        navigateTo("/view/TaskEmployeeView.fxml");
    }

    @FXML
    void inventoryManagement_btn_NavigateOnAction(ActionEvent event) {
        navigateTo("/view/TaskInventoryView.fxml");
    }

    @FXML
    void Notification_btn_NavigateOnAction(ActionEvent event) {
        navigateTo("/view/NotificationView.fxml");
    }

    public void GenarateReport_OnAction(ActionEvent event) {
        try {
            // Load the JasperDesign from the JRXML file
            JasperDesign design = JRXmlLoader.load("src/main/resources/report/kannadi.jrxml");

            // Compile the JasperReport
            JasperReport jasperReport1 = JasperCompileManager.compileReport(design);

            // Add parameters (if needed)
            HashMap<String, Object> parameters = new HashMap<>();
            parameters.put("Day", "2024-11-11");

            // Establish a database connection
            Connection connection = DBConnection.getInstance().getConnection();

            // Fill the report with data
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport1, parameters, connection);

            // Display the report
            JasperViewer.viewReport(jasperPrint, false);

        } catch (JRException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Failed to generate report: " + e.getMessage()).show();

        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Database error: " + e.getMessage()).show();

        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Unexpected error: " + e.getMessage()).show();
        }
    }

}


