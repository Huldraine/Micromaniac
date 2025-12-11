module micromania.micromania {
    requires javafx.controls;
    requires javafx.fxml;


    opens micromania.micromania to javafx.fxml;
    exports micromania.micromania;
}