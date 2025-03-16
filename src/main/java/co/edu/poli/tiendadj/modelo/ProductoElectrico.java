package co.edu.poli.tiendadj.modelo;

// ProductoElectrico implementando el Prototype
public class ProductoElectrico extends Producto implements ProductoPrototype {
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

    @Override
    public Producto clonar() {
        return new ProductoElectrico(getId(), getDescripcion(), this.voltInput);
    }

    @Override
    public String toString() {
        return "ProductoElectrico [id=" + getId() + ", descripcion=" + getDescripcion() +
                ", voltInput=" + voltInput + "]";
    }
}