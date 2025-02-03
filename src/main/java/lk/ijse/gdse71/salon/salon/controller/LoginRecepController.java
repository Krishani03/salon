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

public class LoginRecepController {
    @FXML
    private Button back_btn;

    @FXML
    private Button login_btn;

    @FXML
    private PasswordField password;

    @FXML
    private AnchorPane rLoginPane;

    @FXML
    private TextField username;

    @FXML
    void goToMainLogin(ActionEvent event) throws IOException {
        rLoginPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/MainLoginView.fxml"));
        rLoginPane.getChildren().add(pane);
    }

    @FXML
    void goToRecepTask(ActionEvent event) throws IOException, SQLException {
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("select * from User where Password = ?  && Username = ?");
        preparedStatement.setObject(1,password.getText());
        preparedStatement.setObject(2,username.getText());
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            rLoginPane.getChildren().clear();
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/DashBoardRecepView.fxml"));
            rLoginPane.getChildren().add(pane);
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Username or Password");
            alert.showAndWait();
        }

    }

}
