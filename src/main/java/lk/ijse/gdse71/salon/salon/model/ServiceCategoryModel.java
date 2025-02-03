package lk.ijse.gdse71.salon.salon.model;

import lk.ijse.gdse71.salon.salon.db.DBConnection;
import lk.ijse.gdse71.salon.salon.dto.ServiceCategoryDTO;
import lk.ijse.gdse71.salon.salon.dto.ServiceDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceCategoryModel {

    public List<ServiceCategoryDTO> getallServiceCategory() throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "select * from Service_category";
        PreparedStatement statement = connection.prepareStatement(sql);
        ArrayList<ServiceCategoryDTO> ss = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            ServiceCategoryDTO serviceCategoryDTO = new ServiceCategoryDTO(
                    resultSet.getString("cat_id"),
                    resultSet.getString("cat_name"),
                    resultSet.getString("description"),
                    resultSet.getString("ser_id")
            );
            ss.add(serviceCategoryDTO);
        }
        return ss;
    }
}
