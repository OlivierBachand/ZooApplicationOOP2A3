module com.example.zooapplicationoop2a3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zooapplicationoop2a3 to javafx.fxml;
    exports com.example.zooapplicationoop2a3;
    exports com.example.zooapplicationoop2a3.Controllers;
    opens com.example.zooapplicationoop2a3.Controllers to javafx.fxml;
    exports com.example.zooapplicationoop2a3.Model;
    opens com.example.zooapplicationoop2a3.Model to javafx.fxml;
}