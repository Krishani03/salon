package lk.ijse.gdse71.salon.salon.dto;

public class ServiceDTO {
    private String ser_id;
    private String ser_name;
    private int duration;
    private int salon_id;

    public void ServiceDto(){

    }

    public ServiceDTO(String ser_id, String ser_name, int duration, int salon_id) {
        this.ser_id = ser_id;
        this.ser_name = ser_name;
        this.duration = duration;
        this.salon_id = salon_id;
    }

    public String getSer_id() {
        return ser_id;
    }

    public void setSer_id(String ser_id) {
        this.ser_id = ser_id;
    }

    public String getSer_name() {
        return ser_name;
    }

    public void setSer_name(String ser_name) {
        this.ser_name = ser_name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getSalon_id() {
        return salon_id;
    }

    public void setSalon_id(int salon_id) {
        this.salon_id = salon_id;
    }
}
