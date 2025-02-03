package lk.ijse.gdse71.salon.salon.model;

import javafx.collections.ObservableList;
import lk.ijse.gdse71.salon.salon.db.DBConnection;
import lk.ijse.gdse71.salon.salon.dto.AppointmentDTO;
import lk.ijse.gdse71.salon.salon.dto.CustomerDTO;
import lk.ijse.gdse71.salon.salon.util.CrudUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppoinmentModel{
    private Object selectedAppointmentId;

    public AppoinmentModel(String string, String string1, Time time, Date date, String string2, String string3, String string4) {

    }

    public AppoinmentModel() {

    }

    public String getNextAppointmentId() throws SQLException {
        ResultSet rst =  CrudUtil.execute("select app_id from Appoinment order by app_id desc limit 1");

        if (rst.next()){
            String lastId = rst.getString(1);
            String substring = lastId.substring(3); // 002
            int i = Integer.parseInt(substring); // 2
            int newIdIndex = i+1; // 3
            return String.format("APP%03d",newIdIndex);
        }
        return  "APP001";
    }


    public ArrayList<AppointmentDTO> findById(String selectedCusId) throws SQLException {
        ResultSet rst =  CrudUtil.execute("select * from Appoinment where app_id=?",selectedAppointmentId);

        ArrayList<AppointmentDTO> appointmentDTOS = new ArrayList<>();

        if (rst.next()){
            AppointmentDTO dto = new AppointmentDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getTime(3),
                    rst.getDate(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7)



                    );
            appointmentDTOS.add(dto);
        }
        return appointmentDTOS;
    }

    public Object getCustomerId() {

        return null;
    }

    public boolean saveAppoinment(AppointmentDTO appointmentDTO) throws SQLException {
        boolean isSaved =  CrudUtil.execute(
                "insert into Appoinment values (?,?,?,?,?,?,?)",
                appointmentDTO.getApp_id(),
                appointmentDTO.getService_type(),
                appointmentDTO.getApp_time(),
                appointmentDTO.getApp_date(),
                appointmentDTO.getCustomer_id(),
                appointmentDTO.getPay_id(),
                appointmentDTO.getEm_id()

        );

        return isSaved;
    }

    public List<AppointmentDTO> getallAppoinment() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "select * from Appoinment";
        PreparedStatement statement = connection.prepareStatement(sql);
        ArrayList<AppointmentDTO> ad = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            AppointmentDTO appointmentDTO = new AppointmentDTO(
                    resultSet.getString("app_id"),
                    resultSet.getString("service_type"),
                    resultSet.getTime("app_time"),
                    resultSet.getDate("app_date"),
                    resultSet.getString("customer_id"),
                    resultSet.getString("pay_id"),
                    resultSet.getString("em_id")

                    );
            ad.add(appointmentDTO);
        }
        return ad;
    }

    public List<String> getAllCust() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sl = "Select customer_id from Customer";
        PreparedStatement statement = connection.prepareStatement(sl);
        List<String> ss = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            ss = Collections.singletonList(resultSet.getString("customer_id"));
        }
        return ss;
    }

    public List<AppointmentDTO> dddd() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sl ="Select * from Appoinment ";
        PreparedStatement statement = connection.prepareStatement(sl);
        List<AppointmentDTO> ac = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            AppointmentDTO dd = new AppointmentDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getTime(3),
                    resultSet.getDate(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7)
            );

                            ac.add(dd);

        }
        return ac;
    }
}
