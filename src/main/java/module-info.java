module co.edu.poli.tiendadj {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens co.edu.poli.tiendadj to javafx.fxml;
    exports co.edu.poli.tiendadj;
}