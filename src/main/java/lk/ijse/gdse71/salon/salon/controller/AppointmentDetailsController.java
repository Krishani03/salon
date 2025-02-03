package lk.ijse.gdse71.salon.salon.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse71.salon.salon.dto.AppointmentDTO;
import lk.ijse.gdse71.salon.salon.dto.CustomerDTO;
import lk.ijse.gdse71.salon.salon.model.AppoinmentModel;
import lk.ijse.gdse71.salon.salon.model.CustomerModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class AppointmentDetailsController implements Initializable {
private AppoinmentModel ad;

    @FXML
    private TableColumn<AppointmentDTO, Date> appDate_col;

    @FXML
    private TableColumn<AppointmentDTO, String > appId_col;

    @FXML
    private TableColumn<AppointmentDTO, Time> appTime_col;

    @FXML
    private AnchorPane appoinmentDetails_pane;

    @FXML
    private TableView<AppointmentDTO> appoinmentDetails_tbl;

    @FXML
    private Button back_btn;

    @FXML
    private TableColumn<AppointmentDTO, String> customerId_col;

    @FXML
    private TableColumn<AppointmentDTO, String> employeeId_col;

    @FXML
    private TableColumn<AppointmentDTO, String> payId_col;

    @FXML
    private TableColumn<AppointmentDTO, String> serviceType_col;

    @FXML
    void back_btn_OnAction(ActionEvent event) throws IOException {
        appoinmentDetails_pane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/DashBoardBeautyView.fxml"));
        appoinmentDetails_pane.getChildren().add(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ad = new AppoinmentModel();
        appId_col.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        serviceType_col.setCellValueFactory(new PropertyValueFactory<>("customer_name"));
        appTime_col.setCellValueFactory(new PropertyValueFactory<>("customer_contact"));
        appDate_col.setCellValueFactory(new PropertyValueFactory<>("loyalty_id"));
        customerId_col.setCellValueFactory(new PropertyValueFactory<>("loyalty_id"));
        payId_col.setCellValueFactory(new PropertyValueFactory<>("loyalty_id"));
        employeeId_col.setCellValueFactory(new PropertyValueFactory<>("loyalty_id"));


        try {
            refreshPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AppointmentDetailsController(){

    }

    private void refreshPage() throws SQLException {

        ObservableList<AppointmentDTO> appointmentDTOS = FXCollections.observableArrayList();

        try {
            List<AppointmentDTO> adc = ad.getallAppoinment();
            appointmentDTOS.addAll(adc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        appoinmentDetails_tbl.setItems(appointmentDTOS);

    }
    AppoinmentModel appoinmentModel = new AppoinmentModel();
}
