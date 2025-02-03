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
import lk.ijse.gdse71.salon.salon.dto.CustomerDTO;
import lk.ijse.gdse71.salon.salon.model.CustomerModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerDetailsController implements Initializable {
private CustomerModel cd;

    @FXML
    private AnchorPane appoinmentDetails_pane;

    @FXML
    private Button back_btn;

    @FXML
    private TableColumn<CustomerDTO,Integer > customerContact_col;

    @FXML
    private TableView<CustomerDTO> customerDetail_tbl;

    @FXML
    private TableColumn<CustomerDTO, String > customerId_col;

    @FXML
    private TableColumn<CustomerDTO, String> customerName_col;

    @FXML
    private TableColumn<CustomerDTO, String > loyaltyId_col;

    public void back_btn_OnAction(ActionEvent event) throws IOException {
        appoinmentDetails_pane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/DashBoardBeautyView.fxml"));
        appoinmentDetails_pane.getChildren().add(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cd = new CustomerModel();
        customerId_col.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        customerName_col.setCellValueFactory(new PropertyValueFactory<>("customer_name"));
        customerContact_col.setCellValueFactory(new PropertyValueFactory<>("customer_contact"));
        loyaltyId_col.setCellValueFactory(new PropertyValueFactory<>("loyalty_id"));
        try {
            refreshPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void refreshPage() {

        ObservableList<CustomerDTO> cc = FXCollections.observableArrayList();

        try {
            List<CustomerDTO>  cdo = cd.getallv();
            cc.addAll(cdo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        customerDetail_tbl.setItems(cc);
        
    }

    

    CustomerModel customerModel = new CustomerModel();
    }



