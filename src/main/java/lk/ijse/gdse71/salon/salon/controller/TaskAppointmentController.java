package lk.ijse.gdse71.salon.salon.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse71.salon.salon.dto.AppointmentDTO;
import lk.ijse.gdse71.salon.salon.model.AppoinmentModel;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.ResourceBundle;

public class TaskAppointmentController implements Initializable {

    private AppoinmentModel cDTO;

    @FXML
    private Label AppointmnetId_lbl;

    @FXML
    private AnchorPane Taskappointment_Pane;

    @FXML
    private Label appointmentDate;

    @FXML
    private Button back_btn;

    @FXML
    private Button btnConfirm;

    @FXML
    private Button btnReset;

    @FXML
    private TableColumn<AppointmentDTO, Date> colAppDate;

    @FXML
    private TableColumn<AppointmentDTO, String >colAppId;

    @FXML
    private TableColumn<AppointmentDTO, Time> colAppTime;

    @FXML
    private TableColumn<AppointmentDTO, String> colCustomerId;

    @FXML
    private TableColumn<AppointmentDTO, String> colEm_id;

    @FXML
    private TableColumn<AppointmentDTO, String> colPayId;

    @FXML
    private TableColumn<AppointmentDTO, String> colServiceType;

    @FXML
    private Label lblAppTime;

    @FXML
    private Label lblPayId;

    @FXML
    private TableView<AppointmentDTO> tblTaskAppointment;

    @FXML
    private TextField txtEmployeeId;

    @FXML
    private TextField txt_customerId;

    @FXML
    private TextField txt_serviceType;

         @FXML
        void btnConfirmOnAction(ActionEvent event) throws SQLException {

        String app_id = AppointmnetId_lbl.getText();
        String service_type = txt_serviceType.getText();
        Time app_time = Time.valueOf((lblAppTime.getText()));
        Date app_date = Date.valueOf((appointmentDate.getText()));
        String customer_id = txt_customerId.getId();
        String pay_id = lblPayId.getText();
        String em_id = txtEmployeeId.getText();



        AppointmentDTO appointmentDTO = new AppointmentDTO(
                app_id,
                service_type,
                app_time,
                app_date,
                customer_id,
                pay_id,
                em_id
        );

        boolean isSaved = appoinmentModel.saveAppoinment(appointmentDTO);
        if (isSaved) {
            refreshPage();
            new Alert(Alert.AlertType.INFORMATION, "Appoinment saved...!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Fail to save Appoinment...!").show();
        }
        }

        @FXML
        void btnResetOnAction(ActionEvent event) throws SQLException {
            refreshPage();
        }

    @FXML
    void back_btn_OnAction(ActionEvent event) throws IOException {

        Taskappointment_Pane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/DashBoardRecepView.fxml"));
        Taskappointment_Pane.getChildren().add(pane);
    }

            @FXML
            void cmbCustomerOnAction(ActionEvent event) throws SQLException {
//             ObservableList<String> sli = FXCollections.observableArrayList();
//
//             try{
//                 List<String> ss = cDTO.getAllCust();
//                 sli.addAll(ss);
//                 cmbCustomerId.setItems(sli);
//
//             } catch (SQLException e) {
//                 throw new RuntimeException(e);
//             }
//                String selectedCusId = (String) cmbCustomerId.getSelectionModel().getSelectedItem();
//
//
//                ArrayList<AppointmentDTO> cDTO = appointmentModel.findById(selectedCusId);
//
//
//                String selectedCustomerId = cmbCustomerId.getSelectionModel().getSelectedItem();
//                CustomerDTO customerDTO = customerModel.findById(selectedCustomerId);
//
//                if (customerDTO != null) {
//                    cmbCustomerId.setItems(customerDTO.getCustomer_name());
//                }
//                if (customerDTO != null) {
//
//                    ObservableList<String> customerIds = FXCollections.observableArrayList();
//                    for (Object obj : customerDTO.getCustomer_id()) {
//                        customerIds.add(obj.toString());
//                    }
//
//                    cmbCustomerId.setItems(customerIds);
//                }
            }




    @FXML
        void cmbItemOnAction(ActionEvent event) {

        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
             cDTO = new AppoinmentModel();

        colAppId.setCellValueFactory(new PropertyValueFactory<>("app_id"));
        colServiceType.setCellValueFactory(new PropertyValueFactory<>("service_type"));
        colAppTime.setCellValueFactory(new PropertyValueFactory<>("app_time"));
        colAppDate.setCellValueFactory(new PropertyValueFactory<>("app_date"));
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        colPayId.setCellValueFactory(new PropertyValueFactory<>("pay_id"));
        colEm_id.setCellValueFactory(new PropertyValueFactory<>("em_id"));



        try {
//         loadNextAppoinmentId();
            refreshPage();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Fail to load appointment id").show();
        }
    }

    private void refreshPage() throws SQLException {
//        loadNextAppoinmentId();

        ObservableList<AppointmentDTO> ac = FXCollections.observableArrayList();
        try {
            List<AppointmentDTO> vbhg = cDTO.getallAppoinment();
            ac.addAll(vbhg);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tblTaskAppointment.setItems(ac);
        btnConfirm.setDisable(false);

        txtEmployeeId.setText("");
        txt_serviceType.setText("");
        txt_customerId.setText("");
        lblPayId.setText("");
        lblAppTime.setText("");

//        ObservableList<String>

    }
    AppoinmentModel appoinmentModel = new AppoinmentModel();

//    private void loadNextAppoinmentId() throws SQLException {
//        String nextAppointmentId = appoinmentModel.getNextAppointmentId();
//        AppointmentId_lbl.setText(nextAppointmentId);
//    }
}


