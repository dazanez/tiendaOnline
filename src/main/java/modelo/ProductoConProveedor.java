package modelo;

public class ProductoConProveedor {
    public static void crearProducto(String nombreProducto, String nombreProveedor) {
        Proveedor proveedor = ProveedorFactory.obtenerProveedor(nombreProveedor);
        System.out.println("Creando producto: " + nombreProducto);
        proveedor.mostrar();
    }

    public static void mostrarProveedores() {
        ProveedorFactory.mostrarTodos();
    }
}