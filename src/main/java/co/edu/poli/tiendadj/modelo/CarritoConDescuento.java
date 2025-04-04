package co.edu.poli.tiendadj.modelo;

public class CarritoConDescuento extends CarritoDecorator {
    private double porcentaje;

    public CarritoConDescuento(Carrito carrito, double porcentaje) {
        super(carrito);
        this.porcentaje = porcentaje;
    }

    @Override
    public double calcularTotal() {
        return super.calcularTotal() * (1 - porcentaje);
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Descuento del " + (porcentaje * 100) + "%";
    }
}

