module Stand {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens Stand to javafx.fxml;
    exports Stand;
}