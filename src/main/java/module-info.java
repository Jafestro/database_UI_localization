module org.example.database_ui_localization {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.database_ui_localization to javafx.fxml;
    exports org.example.database_ui_localization;
}