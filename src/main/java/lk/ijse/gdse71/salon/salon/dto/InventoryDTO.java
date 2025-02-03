package lk.ijse.gdse71.salon.salon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InventoryDTO {
    private String in_id;
    private String item_name;
    private Integer quantity;
    private Integer salon_id;
/*
    public InventoryDTO() {

    }*/

    /*public InventoryDTO(String inId, String itemName, Integer quantity, Integer salonId) {
        this.in_id = in_id;
        this.item_name = item_name;
        this.quantity =quantity;
        this.salon_id =salon_id;
    }

    public String getIn_id() {
        return in_id;
    }

    public void setIn_id(String in_id) {
        this.in_id = in_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getSalon_id() {
        return salon_id;
    }

    public void setSalon_id(Integer salon_id) {
        this.salon_id = salon_id;
    }
*/}
