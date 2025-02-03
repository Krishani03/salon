package lk.ijse.gdse71.salon.salon.dto;

public class CustomerDTO {
    private String customer_id;
    private String customer_name;
    private int customer_contact;
    private String loyalty_id;



    public CustomerDTO(String customerId, String customerName, int customerContact, String loyaltyId) {
        this.customer_id = customerId;
        this.customer_name = customerName;
        this.customer_contact = customerContact;
        this.loyalty_id = loyaltyId;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public int getCustomer_contact() {
        return customer_contact;
    }

    public void setCustomer_contact(int customer_contact) {
        this.customer_contact = customer_contact;
    }

    public String getLoyalty_id() {
        return loyalty_id;
    }

    public void setLoyalty_id(String loyalty_id) {
        this.loyalty_id = loyalty_id;
    }

    public String getCustomerId() {

        return customer_id;
    }
}
