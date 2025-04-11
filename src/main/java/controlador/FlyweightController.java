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

        // Crear productos (una sola vez)
        if (ProductoConProveedor.obtenerProductos().isEmpty()) {
            ProductoConProveedor.crearProducto("Shampoo", "EcoBelleza S.A.");
            ProductoConProveedor.crearProducto("Acondicionador", "EcoBelleza S.A.");
            ProductoConProveedor.crearProducto("Tinte Vegano", "ColorVida Ltda.");
            ProductoConProveedor.crearProducto("Esmalte Natural", "EcoBelleza S.A.");
        }

        // Mostrar proveedores
        sb.append("Proveedores registrados:\n");
        ProveedorFactory.proveedores().forEach((k, v) -> sb.append("- ").append(k).append("\n"));

        // Mostrar productos
        sb.append("\nProductos registrados:\n");
        for (ProductoConProveedor producto : ProductoConProveedor.obtenerProductos()) {
            sb.append("- ").append(producto.getNombreProducto())
              .append(" (Proveedor: ").append(producto.getNombreProveedor()).append(")\n");
        }

        resultadoArea.setText(sb.toString());
    }


    public void ejecutar() {
        openVistaModal("/proyecto/softDos/flyweight.fxml", "Flyweight - Proveedores Compartidos");
    }
}
