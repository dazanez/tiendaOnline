package co.edu.poli.tiendadj.modelo;

public class ProductoElectricoFactory implements ProductoFactory {
    @Override
    public ProductoElectrico crearProducto(int id, String descripcion, double voltInput) {
        return new ProductoElectrico(id, descripcion, voltInput);
    }

    @Override
    public ProductoElectrico clone() {
        try {
            return (ProductoElectrico) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error al clonar el producto", e);
        }
    }
}

