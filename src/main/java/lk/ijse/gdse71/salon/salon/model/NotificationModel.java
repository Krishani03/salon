package lk.ijse.gdse71.salon.salon.model;

import lk.ijse.gdse71.salon.salon.db.DBConnection;
import lk.ijse.gdse71.salon.salon.dto.CustomerDTO;
import lk.ijse.gdse71.salon.salon.dto.NotificationDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotificationModel {
    
    public List<NotificationDTO> getallN() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "select * from Notification";
        PreparedStatement statement = connection.prepareStatement(sql);
        ArrayList<NotificationDTO> dd = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
                NotificationDTO notificationDTO = new NotificationDTO(
                    resultSet.getString("not_id"),
                    resultSet.getString("massage"),
                    resultSet.getTime("not_time"),
                    resultSet.getDate("not_date"),
                    resultSet.getString("customer_id")

            );
            dd.add(notificationDTO);
        }
        return dd;

    }
}
