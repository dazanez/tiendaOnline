package co.edu.poli.tiendadj.modelo;

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
}
