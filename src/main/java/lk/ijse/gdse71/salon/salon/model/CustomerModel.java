package lk.ijse.gdse71.salon.salon.model;

import lk.ijse.gdse71.salon.salon.dto.CustomerDTO;
import lk.ijse.gdse71.salon.salon.db.DBConnection;
import lk.ijse.gdse71.salon.salon.util.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerModel{
    public String getNextCustomerId() throws SQLException {
        ResultSet rst =  CrudUtil.execute("select customer_id from Customer order by customer_id desc limit 1");

        if (rst.next()){
            String lastId = rst.getString(1); // C002
            String substring = lastId.substring(4); // 002
            int i = Integer.parseInt(substring); // 2
            int newIdIndex = i+1; // 3
//            String newId = ; // C003
            return String.format("CUST%03d",newIdIndex);
        }
        return  "CUST001";
    }

    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException {
        boolean isSaved =  CrudUtil.execute(
                "insert into Customer values (?,?,?,?)",
                customerDTO.getCustomerId(),
                customerDTO.getCustomer_name(),
                customerDTO.getCustomer_contact(),
                customerDTO.getLoyalty_id()
        );

        return isSaved;
    }

    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException {
        return CrudUtil.execute(
                "update Customer set customer_name=?, customer_contact=?, loyalty_id=? where customer_id=?",
                customerDTO.getCustomer_name(),
                customerDTO.getCustomer_contact(),
                customerDTO.getLoyalty_id(),
                customerDTO.getCustomerId()
        );
    }

    public boolean deleteCustomer(String customerId) throws SQLException {
        return CrudUtil.execute("delete from Customer where customer_id=?",customerId);

    }

    public List<CustomerDTO> getallv() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "select * from Customer";
        PreparedStatement statement = connection.prepareStatement(sql);
        ArrayList<CustomerDTO> dd = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            CustomerDTO customerDTO = new CustomerDTO(
                    resultSet.getString("customer_id"),
                    resultSet.getString("customer_name"),
                    resultSet.getInt("customer_contact"),
                    resultSet.getString("loyalty_id")
            );
            dd.add(customerDTO);
        }
        return dd;
    }

   }



