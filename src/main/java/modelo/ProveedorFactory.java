package modelo;

import java.util.HashMap;

public class ProveedorFactory {
    private static final HashMap<String, Proveedor> proveedores = new HashMap<>();

    public static Proveedor obtenerProveedor(String nombre) {
        proveedores.putIfAbsent(nombre, new Proveedor(nombre));
        return proveedores.get(nombre);
    }

    public static void mostrarTodos() {
        proveedores.values().forEach(Proveedor::mostrar);
    }

    // Método adicional para acceder desde el controlador
    public static HashMap<String, Proveedor> proveedores() {
        return proveedores;
    }
}
