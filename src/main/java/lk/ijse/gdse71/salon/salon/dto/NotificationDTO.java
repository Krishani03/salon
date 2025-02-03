package lk.ijse.gdse71.salon.salon.dto;


import java.sql.Time;
import java.util.Date;

public class NotificationDTO {
    private String not_id;
    private String massage;
    private Time not_time;
    private Date not_date;
    private String customer_id;

    public NotificationDTO() {

    }
    public NotificationDTO(String notId, String massage, Time notTime, Date notDate, String customerId) {
        this.not_id = notId;
        this.massage = massage;
        this.not_time = notTime;
        this.not_date = notDate;
        this.customer_id = customerId;
    }

    public String getNot_id() {
        return not_id;
    }

    public void setNot_id(String not_id) {
        this.not_id = not_id;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public Time getNot_time() {
        return not_time;
    }

    public void setNot_time(Time not_time) {
        this.not_time = not_time;
    }

    public Date getNot_date() {
        return not_date;
    }

    public void setNot_date(Date not_date) {
        this.not_date = not_date;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }
}

