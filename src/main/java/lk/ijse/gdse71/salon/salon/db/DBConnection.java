package lk.ijse.gdse71.salon.salon.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection dbConnection;
    private final Connection connection;
    private DBConnection() throws SQLException {
        connection =   DriverManager.getConnection("jdbc:mysql://localhost:3306/SalonManagement","root","Ijse@1234");
    }
    public static DBConnection getInstance() throws SQLException{
      if(dbConnection == null){
      dbConnection = new DBConnection() ;
      }
      return dbConnection;
    }

    public Connection getConnection (){

        return connection;
    }
}
