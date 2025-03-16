package co.edu.poli.tiendadj.modelo;

// ProductoAlimenticio implementando el Prototype
public class ProductoAlimenticio extends Producto {
    private double aporteCalorico;

    public ProductoAlimenticio(int id, String descripcion, double aporteCalorico) {
        super(id, descripcion);
        this.aporteCalorico = aporteCalorico;
    }

    public double getAporteCalorico() {
        return aporteCalorico;
    }

    public void setAporteCalorico(double aporteCalorico) {
        this.aporteCalorico = aporteCalorico;
    }

    @Override
    public Producto clonar() {
        return new ProductoAlimenticio(getId(), getDescripcion(), this.aporteCalorico);
    }

    @Override
    public String toString() {
        return "ProductoAlimenticio [id=" + getId() + ", descripcion=" + getDescripcion() +
                ", aporteCalorico=" + aporteCalorico + "]";
    }
}
