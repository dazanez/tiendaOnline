package controlador;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import modelo.ProductoConProveedor;
import modelo.ProveedorFactory;

public class FlyweightController extends ControladorBase {

    @FXML
    private TextArea resultadoArea;

    public void mostrarProductos() {
        StringBuilder sb = new StringBuilder();

        // Crear productos usando el modelo
        ProductoConProveedor.crearProducto("Shampoo", "EcoBelleza S.A.");
        ProductoConProveedor.crearProducto("Acondicionador", "EcoBelleza S.A.");
        ProductoConProveedor.crearProducto("Tinte Vegano", "ColorVida Ltda.");
        ProductoConProveedor.crearProducto("Esmalte Natural", "EcoBelleza S.A.");

        // Mostrar proveedores únicos
        sb.append("Proveedores registrados:\n");
        ProveedorFactory.mostrarTodos(); // Esto imprime en consola

        // Mostrar en la interfaz también (en vez de solo consola)
        ProveedorFactory.proveedores().forEach((k, v) -> sb.append("- ").append(k).append("\n"));

        resultadoArea.setText(sb.toString());
    }

    public void ejecutar() {
        openVistaModal("/proyecto/softDos/flyweight.fxml", "Flyweight - Proveedores Compartidos");
    }
}
