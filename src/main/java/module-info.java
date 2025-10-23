module com.example.zooapplicationoop2a3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zooapplicationoop2a3 to javafx.fxml;
    exports com.example.zooapplicationoop2a3;
}