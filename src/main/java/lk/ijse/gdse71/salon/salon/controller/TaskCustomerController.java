package lk.ijse.gdse71.salon.salon.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse71.salon.salon.dto.CustomerDTO;
import lk.ijse.gdse71.salon.salon.dto.tm.CustomerTM;
import lk.ijse.gdse71.salon.salon.model.CustomerModel;
import lk.ijse.gdse71.salon.salon.model.EmployeeModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class TaskCustomerController implements Initializable {
    private CustomerModel cs;
    @FXML
    private TableColumn<CustomerDTO, Integer> CustomerContact_col;

    @FXML
    private TextField CustomerContact_txt;

    @FXML
    private TableColumn<CustomerDTO, String> CustomerId_col;

    @FXML
    private Label CustomerId_lbl;

    @FXML
    private TableColumn<CustomerDTO, String> CustomerName_col;

    @FXML
    private TextField CustomerName_txt;

    @FXML
    private Button Delete_btn;

    @FXML
    private TableColumn<CustomerDTO, String> LoyaltyId_col;

    @FXML
    private TextField LoyaltyId_txt;

    @FXML
    private Button Reset_btn;

    @FXML
    private Button Save_btn;

    @FXML
    private AnchorPane TaskCustomer_pane;

    @FXML
    private TableView<CustomerDTO> TaskCustomer_tbl;


    @FXML
    private Button Update_btn;

    @FXML
    void Delete_btnOnAction(ActionEvent event) throws SQLException {
        String customer_id = CustomerId_lbl.getText();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optionalButtonType = alert.showAndWait();

        if (optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.YES){

            boolean isDeleted = customerModel.deleteCustomer(customer_id);
            if (isDeleted) {
                refreshPage();
                new Alert(Alert.AlertType.INFORMATION, "Customer deleted...!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to delete customer...!").show();
            }
        }
    }

    @FXML
    void Reset_btn_OnAction(ActionEvent event) throws SQLException {
        refreshPage();
    }

    @FXML
    void Save_btn_OnAction(ActionEvent event) throws SQLException {

        if(CustomerId_lbl.getText().isEmpty() || CustomerName_txt.getText().isEmpty() ||CustomerContact_txt.getText().isEmpty() ||LoyaltyId_txt.getText().isEmpty()){
            System.out.println("Testing ...");
            new Alert(Alert.AlertType.INFORMATION, "Fill all the fields first...!").show();
        }
        String customer_id = CustomerId_lbl.getText();
        String customer_name = CustomerName_txt.getText();
        int customer_contact = Integer.parseInt(CustomerContact_txt.getText());
        String loyalty_id = LoyaltyId_txt.getText();


        CustomerDTO customerDTO = new CustomerDTO(
                customer_id,
                customer_name,
                customer_contact,
                loyalty_id
        );

        boolean isSaved = customerModel.saveCustomer(customerDTO);
        if (isSaved) {
            refreshPage();
            new Alert(Alert.AlertType.INFORMATION, "Customer saved...!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Fail to save customer...!").show();
        }
    }

    @FXML
    void Update_btn_OnAction(ActionEvent event) throws SQLException {
        String customer_id = CustomerId_lbl.getText();
        String customer_name = CustomerName_txt.getText();
        int customer_contact = Integer.parseInt(CustomerContact_txt.getText());
        String loyalty_id = LoyaltyId_txt.getText();

        CustomerDTO customerDTO = new CustomerDTO(
                customer_id,
                customer_name,
                customer_contact,
                loyalty_id
        );

        boolean isUpdate = customerModel.updateCustomer(customerDTO);
        if (isUpdate) {
            refreshPage();
            System.out.println("Testing ...");
            new Alert(Alert.AlertType.INFORMATION, "Customer update...!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Fail to update customer...!").show();
        }
    }

    @FXML
    void onClickTable(MouseEvent event) {

            CustomerId_lbl.setText(TaskCustomer_tbl.getSelectionModel().getSelectedItem().getCustomer_id());
            CustomerName_txt.setText(TaskCustomer_tbl.getSelectionModel().getSelectedItem().getCustomer_name());
            CustomerContact_txt.setText(""+TaskCustomer_tbl.getSelectionModel().getSelectedItem().getCustomer_contact());
            LoyaltyId_txt.setText(TaskCustomer_tbl.getSelectionModel().getSelectedItem().getLoyalty_id());


            Save_btn.setDisable(true);

            Delete_btn.setDisable(false);
            Update_btn.setDisable(false);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cs = new CustomerModel();
        CustomerId_col.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        CustomerName_col.setCellValueFactory(new PropertyValueFactory<>("customer_name"));
        CustomerContact_col.setCellValueFactory(new PropertyValueFactory<>("customer_contact"));
        LoyaltyId_col.setCellValueFactory(new PropertyValueFactory<>("loyalty_id"));
        try {
            refreshPage();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Fail to load customer id").show();
        }
    }

    public void TaskCustomerController(){

    }

    private void refreshPage() throws SQLException {
        //cs = new CustomerModel();
        loadNextCustomerId();

        ObservableList<CustomerDTO> dd = FXCollections.observableArrayList();

        try {
            List<CustomerDTO>vbhg = cs.getallv();
            dd.addAll(vbhg);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        TaskCustomer_tbl.setItems(dd);
        Save_btn.setDisable(false);

        CustomerName_txt.setText("");
        CustomerContact_txt.setText("");
        LoyaltyId_txt.setText("");
    }
    CustomerModel customerModel = new CustomerModel();

    private void loadNextCustomerId() throws SQLException {
        String nextCustomerId = customerModel.getNextCustomerId();
        CustomerId_lbl.setText(nextCustomerId);
    }
    @FXML
    void back_btn_OnAction(ActionEvent event) throws IOException {
        TaskCustomer_pane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/DashBoardRecepView.fxml"));
        TaskCustomer_pane.getChildren().add(pane);
    }
}
