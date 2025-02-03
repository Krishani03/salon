package lk.ijse.gdse71.salon.salon.dto;

public class ServiceCategoryDTO {

    private String cat_id;
    private String cat_name;
    private String description;
    private String ser_id;

    public void ServiceCategory(){


    }

    public ServiceCategoryDTO(String cat_id, String cat_name, String description, String ser_id) {
        this.cat_id = cat_id;
        this.cat_name = cat_name;
        this.description = description;
        this.ser_id = ser_id;
    }

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSer_id() {
        return ser_id;
    }

    public void setSer_id(String ser_id) {
        this.ser_id = ser_id;
    }
}
