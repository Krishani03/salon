package lk.ijse.gdse71.salon.salon.model;

import lk.ijse.gdse71.salon.salon.db.DBConnection;
import lk.ijse.gdse71.salon.salon.dto.CustomerDTO;
import lk.ijse.gdse71.salon.salon.dto.ServiceDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceModel {
    public List<ServiceDTO> getallService() throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "select * from Services";
        PreparedStatement statement = connection.prepareStatement(sql);
        ArrayList<ServiceDTO> ss = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            ServiceDTO serviceDTO = new ServiceDTO(
                    resultSet.getString("ser_id"),
                    resultSet.getString("ser_name"),
                    resultSet.getInt("duration"),
                    resultSet.getInt("salon_id")
            );
            ss.add(serviceDTO);
        }
        return ss;
    }
}
