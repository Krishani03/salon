package lk.ijse.gdse71.salon.salon.model;

import lk.ijse.gdse71.salon.salon.db.DBConnection;
import lk.ijse.gdse71.salon.salon.dto.EmployeeDTO;
import lk.ijse.gdse71.salon.salon.dto.InventoryDTO;
import lk.ijse.gdse71.salon.salon.util.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryModel {
    public String getNextInventoryId() throws SQLException {
        ResultSet rst = CrudUtil.execute("select in_id from Inventory order by in_id desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1); // IN002
            String substring = lastId.substring(2); // 002
            int i = Integer.parseInt(substring); // 2
            int newIdIndex = i + 1; // 3
//            String newId = ; // C003
            return String.format("IN%03d", newIdIndex);
        }
        return "IN001";
    }

    public boolean saveInventory(InventoryDTO inventoryDTO) throws SQLException {

        boolean isSaved = CrudUtil.execute(
                "insert into Inventory values (?,?,?,?) ",
                inventoryDTO.getIn_id(),
                inventoryDTO.getItem_name(),
                inventoryDTO.getQuantity(),
                inventoryDTO.getSalon_id()
        );

        return isSaved;
    }

    public boolean deleteInventory(String inId) throws SQLException {

        return CrudUtil.execute("delete from Inventory where in_id=?", inId);

    }

    public List<InventoryDTO> getallI() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "select * from Inventory ";
        PreparedStatement statement = connection.prepareStatement(sql);
        ArrayList<InventoryDTO> ii = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            InventoryDTO inventoryDTO = new InventoryDTO(
                    resultSet.getString("in_id"),
                    resultSet.getString("item_name"),
                    resultSet.getInt("quantity"),
                    resultSet.getInt("salon_id")

            );
            ii.add(inventoryDTO);

        }
        return ii;
    }
}
