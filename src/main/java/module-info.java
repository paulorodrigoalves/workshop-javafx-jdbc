module com.example.workshojavafxjdbc {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.workshojavafxjdbc to javafx.fxml;
    exports com.example.workshojavafxjdbc;
    exports com.example.workshojavafxjdbc.model.entities;
    opens com.example.workshojavafxjdbc.model.entities to javafx.fxml;


}