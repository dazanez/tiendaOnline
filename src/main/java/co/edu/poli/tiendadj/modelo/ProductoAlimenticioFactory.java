package co.edu.poli.tiendadj.modelo;

public class ProductoAlimenticioFactory implements ProductoFactory {
    @Override
    public ProductoAlimenticio crearProducto(int id, String descripcion, double aporteCalorico) {
        return new ProductoAlimenticio(id, descripcion, aporteCalorico);
    }
}

