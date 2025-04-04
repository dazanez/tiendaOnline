package co.edu.poli.tiendadj.modelo;

public class CarritoConPuntos extends CarritoDecorator {
    private int puntos;

    public CarritoConPuntos(Carrito carrito) {
        super(carrito);
        this.puntos = (int) (carrito.calcularTotal() / 10); // Ej: 1 punto por cada 10 unidades de dinero
    }

    public int getPuntos() {
        return puntos;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Acumulación de " + puntos + " puntos";
    }
}

