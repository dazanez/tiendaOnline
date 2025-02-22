package co.edu.poli.tiendaOnline.modelo;

public class ProductoAlimenticio extends Producto {
    private float aporteCalorico;

    public ProductoAlimenticio(int id, String description, float aporteCalorico) {
        super(id, description);
        this.aporteCalorico = aporteCalorico;
    }

    public float getAporteCalorico() {
        return aporteCalorico;
    }

    public void setAporteCalorico(float aporteCalorico) {
        this.aporteCalorico = aporteCalorico;
    }
}
