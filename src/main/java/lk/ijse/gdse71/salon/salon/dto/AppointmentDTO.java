package lk.ijse.gdse71.salon.salon.dto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Date;
import java.sql.Time;


public class AppointmentDTO {

    private String app_id;
    private String service_type;
    private Time app_time;
    private Date app_date;
    private String customer_id;
    private String pay_id;
    private String em_id;

    public AppointmentDTO(){

    }

    public AppointmentDTO(String app_id, String service_type, Time app_time, Date app_date, String customer_id, String pay_id, String em_id) {
        this.app_id = app_id;
        this.service_type = service_type;
        this.app_time = app_time;
        this.app_date = app_date;
        this.customer_id = customer_id;
        this.pay_id = pay_id;
        this.em_id = em_id;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public Time getApp_time() {
        return app_time;
    }

    public void setApp_time(Time app_time) {
        this.app_time = app_time;
    }

    public Date getApp_date() {
        return app_date;
    }

    public void setApp_date(Date app_date) {
        this.app_date = app_date;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getPay_id() {
        return pay_id;
    }

    public void setPay_id(String pay_id) {
        this.pay_id = pay_id;
    }

    public String getEm_id() {
        return em_id;
    }

    public void setEm_id(String em_id) {
        this.em_id = em_id;
    }
}

