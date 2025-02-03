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
import lk.ijse.gdse71.salon.salon.dto.NotificationDTO;
import lk.ijse.gdse71.salon.salon.model.NotificationModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public  class NotificationController implements Initializable {
    private NotificationModel nc;
    @FXML
    private Button back_btn;

    @FXML
    private TableColumn<NotificationDTO, String > customerId_col;

    @FXML
    private TableColumn<NotificationDTO, String > massage_col;

    @FXML
    private TableColumn<NotificationDTO, Date> notDate_col;

    @FXML
    private TableColumn<NotificationDTO, String > notId_col;

    @FXML
    private TableColumn<NotificationDTO, Time> notTime_col;

    @FXML
    private AnchorPane notification_pane;

    @FXML
    private TableView<NotificationDTO> notification_tbl;

    @FXML
    void back_btn_OnAction(ActionEvent event) throws IOException {
        notification_pane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/DashBoardManagerView.fxml"));
        notification_pane.getChildren().add(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nc = new NotificationModel();
        notId_col.setCellValueFactory(new PropertyValueFactory<>("not_id"));
        massage_col.setCellValueFactory(new PropertyValueFactory<>("massage"));
        notTime_col.setCellValueFactory(new PropertyValueFactory<>("not_time"));
        notDate_col.setCellValueFactory(new PropertyValueFactory<>("not_date"));
        customerId_col.setCellValueFactory(new PropertyValueFactory<>("customer_id"));

        try {
            refreshPage();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }



    private void refreshPage() throws SQLException {

        ObservableList<NotificationDTO> dd = FXCollections.observableArrayList();

        try {
            List<NotificationDTO> vbhg = nc.getallN();
            dd.addAll(vbhg);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        notification_tbl.setItems(dd);


    }NotificationModel notificationModel = new NotificationModel();


}

