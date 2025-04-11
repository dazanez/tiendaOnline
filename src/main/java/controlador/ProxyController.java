package controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Producto;
import modelo.ProductoProxy;

public class ProxyController {

    @FXML private TextField txtRol;
    @FXML private Label lblResultado;

    @FXML
    public void mostrarDetalles() {
        String rol = txtRol.getText().trim();
        Producto proxy = new ProductoProxy(rol);

        // Muestra el mensaje directamente en la interfaz
        if (rol.equals("admin")) {
            lblResultado.setText("Detalles de producto: Nombre, precio, descripción...");
        } else {
            lblResultado.setText("Acceso denegado: nivel de autorización insuficiente");
        }

        proxy.mostrarDetalles(); // También imprime en consola si deseas
    }
}