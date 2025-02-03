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
import lk.ijse.gdse71.salon.salon.dto.EmployeeDTO;
import lk.ijse.gdse71.salon.salon.dto.InventoryDTO;
import lk.ijse.gdse71.salon.salon.dto.tm.InventoryTM;
import lk.ijse.gdse71.salon.salon.model.EmployeeModel;
import lk.ijse.gdse71.salon.salon.model.InventoryModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class TaskInventoryController implements Initializable {

    private InventoryModel is;
    @FXML
    private TableColumn<InventoryDTO, String> InventoryId_Col;

    @FXML
    private Label InventoryId_lbl;

    @FXML
    private TableColumn<InventoryDTO, String> ItemName_Col;

    @FXML
    private TableColumn<InventoryDTO, Integer> Quantity_Col;

    @FXML
    private TableColumn<InventoryDTO, Integer> SalonId_Col;

    @FXML
    private TextField SalonId_txt;

    @FXML
    private AnchorPane TaskInventory_Pane;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button back_btn;

    @FXML
    private TextField itemName_txt;

    @FXML
    private TextField quantity_txt;

    @FXML
    private TableView<InventoryDTO> tblInventory;

    @FXML
    void back_btn_OnAction(ActionEvent event) throws IOException {
        TaskInventory_Pane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/DashBoardManagerView.fxml"));
        TaskInventory_Pane.getChildren().add(pane);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException {
        String in_id = InventoryId_lbl.getText();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optionalButtonType = alert.showAndWait();

        if (optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.YES){

            boolean isDeleted = inventoryModel.deleteInventory(in_id);
            if (isDeleted) {
                refreshPage();
                new Alert(Alert.AlertType.INFORMATION, "Customer deleted...!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to delete customer...!").show();
            }
        }
    }

    @FXML
    void btnResetOnAction(ActionEvent event) throws SQLException {
        refreshPage();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException {
        System.out.println("click");
        String in_id =InventoryId_lbl.getText();
        String item_name =itemName_txt.getText();
        int quantity =Integer.parseInt(quantity_txt.getText());
        int salon_id =Integer.parseInt(SalonId_txt.getText());

        InventoryDTO inventoryDTO = new InventoryDTO(
                in_id,
                item_name,
                quantity,
                salon_id
        );

        boolean isSaved = inventoryModel.saveInventory(inventoryDTO);
        if (isSaved) {
            refreshPage();
            new Alert(Alert.AlertType.INFORMATION, "Item saved...!").show();

        } else {
            new Alert(Alert.AlertType.ERROR, "Fail to save Item...!").show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException {
        String in_id =InventoryId_lbl.getText();
        String item_name =itemName_txt.getText();
        int quantity =Integer.parseInt(quantity_txt.getText());
        int salon_id =Integer.parseInt(SalonId_txt.getText());


        InventoryDTO inventoryDTO = new InventoryDTO(
                in_id,
                item_name,
                quantity,
                salon_id
        );

        boolean isSaved = inventoryModel.saveInventory(inventoryDTO);
        if (isSaved) {
            refreshPage();
            new Alert(Alert.AlertType.INFORMATION, "Item saved...!").show();

        } else {
            new Alert(Alert.AlertType.ERROR, "Fail to save Item...!").show();
        }
    }

    @FXML
    void onClickTable(MouseEvent event) {
//        InventoryTM inventoryTM = (InventoryTM) tblInventory.getSelectionModel().getSelectedItem();
//        if (inventoryTM != null){
//            InventoryId_lbl.setText(inventoryTM.getin_id());
//            itemName_txt.setText(inventoryTM.getitem_name());
//            quantity_txt.setText(inventoryTM.getquantity());
//            SalonId_txt.setText(inventoryTM.getsalon_id());
//
//
//            btnSave.setDisable(true);
//
//            btnDelete.setDisable(false);
//            btnUpdate.setDisable(false);
//        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        is =new InventoryModel();
        InventoryId_Col.setCellValueFactory(new PropertyValueFactory<>("in_id"));
        ItemName_Col.setCellValueFactory(new PropertyValueFactory<>("item_name"));
        Quantity_Col.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        SalonId_Col.setCellValueFactory(new PropertyValueFactory<>("salon_id"));

        try {
            refreshPage();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Fail to load employee id").show();
        }
    }

    public void TaskInventoryController(){

    }

    private void refreshPage() throws SQLException {
        loadNextEmployeeId();

        ObservableList<InventoryDTO> ii = FXCollections.observableArrayList();

        try {
            List<InventoryDTO>  ti = is.getallI();
            ii.addAll(ii);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        tblInventory.setItems(ii);
        btnSave.setDisable(false);

        itemName_txt.setText("");
        quantity_txt.setText("");
        SalonId_txt.setText("");
    }
    InventoryModel inventoryModel = new InventoryModel();

    private void loadNextEmployeeId() throws SQLException {
        String nextEmployeeId = inventoryModel.getNextInventoryId();
        InventoryId_lbl.setText(nextEmployeeId);
    }
    }

