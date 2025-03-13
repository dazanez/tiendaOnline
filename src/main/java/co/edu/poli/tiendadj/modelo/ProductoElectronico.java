package co.edu.poli.tiendadj.modelo;

public class ProductoElectronico extends Producto {
    private float voltInput;
    public ProductoElectronico(int id, String descripcion, float voltInput) {
        super(id, descripcion);
        this.voltInput = voltInput;
    }

    public float getVoltInput() {
        return voltInput;
    }

    public void setVoltInput(float voltInput) {
        this.voltInput = voltInput;
    }
}
