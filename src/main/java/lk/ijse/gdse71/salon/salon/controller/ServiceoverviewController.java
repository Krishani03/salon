package lk.ijse.gdse71.salon.salon.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse71.salon.salon.dto.ServiceCategoryDTO;
import lk.ijse.gdse71.salon.salon.dto.ServiceDTO;
import lk.ijse.gdse71.salon.salon.model.ServiceCategoryModel;
import lk.ijse.gdse71.salon.salon.model.ServiceModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class ServiceoverviewController implements Initializable {
    private ServiceModel so;
    private ServiceCategoryModel sc;
    @FXML
    private Button back_btn;

    @FXML
    private TableColumn<ServiceCategoryDTO, String> catId_col;

    @FXML
    private TableColumn<ServiceCategoryDTO, String> catName_col;

    @FXML
    private TableColumn<ServiceCategoryDTO, String > description_col;

    @FXML
    private TableColumn<ServiceDTO, Integer> duration_col;

    @FXML
    private TableColumn<ServiceDTO, Integer> salonId_col;

    @FXML
    private TableColumn<ServiceDTO, String> serId_col;

    @FXML
    private TableColumn<ServiceDTO, String> serName_col;

    @FXML
    private TableColumn<ServiceCategoryDTO, String> serid_col;

    @FXML
    private TableView<ServiceCategoryDTO> serviceCategory_tbl;

    @FXML
    private TableView<ServiceDTO> service_tbl;

    @FXML
    private AnchorPane serviceOverview_pane;

    @FXML
    void back_btn_OnAction(ActionEvent event) throws IOException {
        serviceOverview_pane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/DashBoardRecepView.fxml"));
        serviceOverview_pane.getChildren().add(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        so = new ServiceModel();
        serId_col.setCellValueFactory(new PropertyValueFactory<>("ser_id"));
        serName_col.setCellValueFactory(new PropertyValueFactory<>("ser_name"));
        duration_col.setCellValueFactory(new PropertyValueFactory<>("duration"));
        salonId_col.setCellValueFactory(new PropertyValueFactory<>("salon_id"));

        sc =new ServiceCategoryModel();
        catId_col.setCellValueFactory(new PropertyValueFactory<>("cat_id"));
        catName_col.setCellValueFactory(new PropertyValueFactory<>("cat_name"));
        description_col.setCellValueFactory(new PropertyValueFactory<>("description"));
        serid_col.setCellValueFactory(new PropertyValueFactory<>("ser_id"));
        try {
            refreshPage();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void refreshPage() throws SQLException {

        ObservableList<ServiceDTO> ss = FXCollections.observableArrayList();

        List<ServiceDTO> seO = so.getallService();
        ss.addAll(seO);
        service_tbl.setItems(ss);

        ObservableList<ServiceCategoryDTO>  sc =FXCollections.observableArrayList();
        List<ServiceCategoryDTO> sco = serviceCategoryModel.getallServiceCategory();
        sc.addAll(sco);
        serviceCategory_tbl.setItems(sc);



    }
    ServiceModel serviceModel = new ServiceModel();
    ServiceCategoryModel serviceCategoryModel = new ServiceCategoryModel();
}
