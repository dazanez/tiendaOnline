package co.edu.poli.tiendadj.modelo;

public interface ProductoFactory {
    Producto crearProducto(int id, String descripcion, double extra);
}