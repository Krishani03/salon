package lk.ijse.gdse71.salon.salon.dto;

public class EmployeeDTO {
    private String em_id;
    private String em_name;
    private String role;
    private String salon_id;

    public String getEm_id() {
        return em_id;
    }

    public void setEm_id(String em_id) {
        this.em_id = em_id;
    }

    public String getEm_name() {
        return em_name;
    }

    public void setEm_name(String em_name) {
        this.em_name = em_name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSalon_id() {
        return salon_id;
    }

    public void setSalon_id(String salon_id) {
        this.salon_id = salon_id;
    }

    public EmployeeDTO(String em_id, String em_name, String role, String salon_id) {
        this.em_id = em_id;
        this.em_name = em_name;
        this.role = role;
        this.salon_id = salon_id;
    }
}
