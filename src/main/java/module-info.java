module com.example.workshojavafxjdbc {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.workshojavafxjdbc to javafx.fxml;
    exports com.example.workshojavafxjdbc;
    exports com.example.workshojavafxjdbc.entities;
    opens com.example.workshojavafxjdbc.entities to javafx.fxml;


}