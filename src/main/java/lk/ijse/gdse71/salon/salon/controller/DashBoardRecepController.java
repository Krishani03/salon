package lk.ijse.gdse71.salon.salon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DashBoardRecepController {

    @FXML
    private AnchorPane DashboardRecep_Pane;

    @FXML
    private Button back_btn;

    @FXML
    private Button customerManage_btn;

    @FXML
    private Button itemManage_btn;

    @FXML
    private Button serviceOverview_btn;

    @FXML
    void back_btn_NavigateOnAction(ActionEvent event) {
        navigateTo("/view/LoginRecepView.fxml");

    }

    private void navigateTo(String fxmlPath) {

        try {
            DashboardRecep_Pane.getChildren().clear();
            AnchorPane load = FXMLLoader.load(getClass().getResource(fxmlPath));
            load.prefWidthProperty().bind(DashboardRecep_Pane.widthProperty());
            load.prefHeightProperty().bind(DashboardRecep_Pane.heightProperty());
            DashboardRecep_Pane.getChildren().add(load);
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Fail to load page!").show();
        }
    }

    @FXML
    void customerManage_btn_NavigateOnAction(ActionEvent event) {
        navigateTo("/view/TaskCustomerView.fxml");
    }

    @FXML
    void itemManage_btn_NavigateOnAction(ActionEvent event) {
        navigateTo("/view/TaskAppoinmentView.fxml");
    }

    @FXML
    void serviceOverview_btn_Navigate(ActionEvent event) {
        navigateTo("/view/Serviceoverview.fxml");
    }

}
