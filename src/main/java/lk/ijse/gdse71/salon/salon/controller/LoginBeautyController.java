package lk.ijse.gdse71.salon.salon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse71.salon.salon.db.DBConnection;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginBeautyController {
    @FXML
    private Button back_btn;

    @FXML
    private AnchorPane beautyLoginPane;

    @FXML
    private Button login_btn;

    @FXML
    private PasswordField password;

    @FXML
    private TextField userName;

    @FXML
    void backToMainLogin(ActionEvent event) throws IOException {
        beautyLoginPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/MainLoginView.fxml"));
        beautyLoginPane.getChildren().add(pane);
    }

    @FXML
    void goToTaskBeauty(ActionEvent event) throws IOException, SQLException {
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("select * from User where Password = ?  && Username = ?");
        preparedStatement.setObject(1,password.getText());
        preparedStatement.setObject(2,userName.getText());
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            beautyLoginPane.getChildren().clear();
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/DashBoardBeautyView.fxml"));
            beautyLoginPane.getChildren().add(pane);
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Username or Password");
            alert.showAndWait();
        }

    }
}
