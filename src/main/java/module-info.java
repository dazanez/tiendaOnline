module proyecto.softDos {
    requires javafx.controls;
    requires javafx.fxml;

    opens vista to javafx.fxml;
    exports vista;

    exports controlador;
    opens controlador to javafx.fxml;
}
