package modelo;

import java.util.ArrayList;
import java.util.List;

public class ProductoConProveedor {
    private String nombreProducto;
    private Proveedor proveedor;

    // Lista para guardar los productos creados
    private static final List<ProductoConProveedor> productos = new ArrayList<>();

    public ProductoConProveedor(String nombreProducto, Proveedor proveedor) {
        this.nombreProducto = nombreProducto;
        this.proveedor = proveedor;
    }

    public static void crearProducto(String nombreProducto, String nombreProveedor) {
        Proveedor proveedor = ProveedorFactory.obtenerProveedor(nombreProveedor);
        ProductoConProveedor producto = new ProductoConProveedor(nombreProducto, proveedor);
        productos.add(producto);
        System.out.println("Creando producto: " + nombreProducto);
        proveedor.mostrar();
    }

    public static List<ProductoConProveedor> obtenerProductos() {
        return productos;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getNombreProveedor() {
        return proveedor.getNombre();
    }

    public static void mostrarProveedores() {
        ProveedorFactory.mostrarTodos();
    }
}
