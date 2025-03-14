package co.edu.poli.tiendadj.modelo;

public class ProductoElectrico extends Producto {
    private double voltInput;
    public ProductoElectrico(int id, String descripcion, double voltInput) {
        super(id, descripcion);
        this.voltInput = voltInput;
    }

    public double getVoltInput() {
        return voltInput;
    }

    public void setVoltInput(double voltInput) {
        this.voltInput = voltInput;
    }
}
