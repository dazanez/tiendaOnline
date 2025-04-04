package co.edu.poli.tiendadj.modelo;

public abstract class CarritoDecorator implements Carrito {
    protected Carrito carrito;

    public CarritoDecorator(Carrito carrito) {
        this.carrito = carrito;
    }

    @Override
    public double calcularTotal() {
        return carrito.calcularTotal();
    }

    @Override
    public String getDescripcion() {
        return carrito.getDescripcion();
    }
}
