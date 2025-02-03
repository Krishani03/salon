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

public class LoginManagerController {
    @FXML
    private Button back_btn;

    @FXML
    private AnchorPane loginManagerPane;

    @FXML
    private Button login_btn;

    @FXML
    private PasswordField password;

    @FXML
    private TextField userName;

    @FXML
    void backToMainLogin(ActionEvent event) throws IOException {
        loginManagerPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/DashBoardRecepView.fxml"));
        loginManagerPane.getChildren().add(pane);
    } 

    @FXML
    void goToManagerTask(ActionEvent event) throws IOException, SQLException {
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("select * from User where Password = ?  && Username = ?");
        preparedStatement.setObject(1,password.getText());
        preparedStatement.setObject(2,userName.getText());
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            loginManagerPane.getChildren().clear();
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/DashBoardManagerView.fxml"));
            loginManagerPane.getChildren().add(pane);
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Username or Password");
            alert.showAndWait();
        }
    }

    public void goToAddItemView(ActionEvent event) {
    }

    public void goToItemDetailsView(ActionEvent event) {
    }

    public void goToRecepTask(ActionEvent event) {
        
    }
}
