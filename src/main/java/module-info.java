module lk.ijse.gdse71.salon.salon {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jasperreports;
    requires static lombok;

    opens lk.ijse.gdse71.salon.salon.controller to javafx.fxml;
    exports lk.ijse.gdse71.salon.salon;
    exports lk.ijse.gdse71.salon.salon.dto;
}