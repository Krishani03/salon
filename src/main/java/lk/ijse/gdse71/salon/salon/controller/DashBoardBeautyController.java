package lk.ijse.gdse71.salon.salon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DashBoardBeautyController {

    @FXML
    private AnchorPane DashboardBeauty_Pane;

    @FXML
    private Button appointmentDetail_btn;

    @FXML
    private Button back_btn;

    @FXML
    private Button customerDetail_btn;

    @FXML
    void appointmentDetail_btn_OnAction(ActionEvent event) throws IOException {
        DashboardBeauty_Pane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/AppointmentDetailsView.fxml"));
        DashboardBeauty_Pane.getChildren().add(pane);
    }

    @FXML
    void back_btn_OnAction(ActionEvent event) throws IOException {
        DashboardBeauty_Pane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/LoginBeautyView.fxml"));
        DashboardBeauty_Pane.getChildren().add(pane);
    }

    @FXML
    void customerDetail_btn_OnAction(ActionEvent event) throws IOException {
        DashboardBeauty_Pane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/CustomerDetailsView.fxml"));
        DashboardBeauty_Pane.getChildren().add(pane);
    }

}
