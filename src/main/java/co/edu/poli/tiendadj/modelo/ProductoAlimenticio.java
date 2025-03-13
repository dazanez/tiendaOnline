package co.edu.poli.tiendadj.modelo;

public class ProductoAlimenticio extends Producto {
    private float aporteCalorico;

    public ProductoAlimenticio(int id, String descripcion, float aporteCalorico) {
        super(id, descripcion);
        this.aporteCalorico = aporteCalorico;
    }

    public float getAporteCalorico() {
        return aporteCalorico;
    }

    public void setAporteCalorico(float aporteCalorico) {
        this.aporteCalorico = aporteCalorico;
    }
}
