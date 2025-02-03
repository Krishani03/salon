package lk.ijse.gdse71.salon.salon.model;

import lk.ijse.gdse71.salon.salon.dto.EmployeeDTO;
import lk.ijse.gdse71.salon.salon.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeModel {

    public String getNextEmployeeId() throws SQLException {
        ResultSet rst =  CrudUtil.execute("select em_id from Employee order by em_id desc limit 1");

        if (rst.next()){
            String lastId = rst.getString(1); // C002
            String substring = lastId.substring(2); // 002
            int i = Integer.parseInt(substring); // 2
            int newIdIndex = i+1; // 3
//            String newId = ; // C003
            return String.format("EM%03d",newIdIndex);
        }
        return  "EM001";
    }

    public boolean saveEmployee(EmployeeDTO employeeDTO) throws SQLException {
        boolean isSaved =  CrudUtil.execute(
                "insert into Employee values (?,?,?,?)",
                employeeDTO.getEm_id(),
                employeeDTO.getEm_name(),
                employeeDTO.getRole(),
                employeeDTO.getSalon_id()
        );

        return isSaved;
    }
}
