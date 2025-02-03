package lk.ijse.gdse71.salon.salon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainLoginController {

    @FXML
    private Button BeauticianLogin_btn;

    @FXML
    private Label LoginAs;

    @FXML
    private Button ManagerLogin_btn;

    @FXML
    private Button ReceptionistLogin_btn;

    @FXML
    private AnchorPane mainPane;

    @FXML
    void goToBeautyLogin(ActionEvent event) throws IOException {
        mainPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/LoginBeautyView.fxml"));
        mainPane.getChildren().add(pane);
    }

    @FXML
    void goToManagerLogin(ActionEvent event) throws IOException {
        mainPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/LoginManagerView.fxml"));
        mainPane.getChildren().add(pane);
    }

    @FXML
    void goToRecepLogin(ActionEvent event) throws IOException {
        mainPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/LoginRecepView.fxml"));
        mainPane.getChildren().add(pane);
    }
}
