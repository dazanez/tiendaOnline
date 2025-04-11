package modelo;

import java.util.HashMap;

public class ProveedorFactory {
    private static final HashMap<String, Proveedor> proveedores = new HashMap<>();

    public static Proveedor obtenerProveedor(String nombre) {
        if (!proveedores.containsKey(nombre)) {
            Proveedor nuevo = new Proveedor(nombre);
            proveedores.put(nuevo.getNombre(), nuevo); // Clave definida por el propio objeto
        }
        return proveedores.get(nombre);
    }

    public static void mostrarTodos() {
        proveedores.values().forEach(Proveedor::mostrar);
    }

    public static HashMap<String, Proveedor> proveedores() {
        return proveedores;
    }
}
