package co.edu.poli.tiendadj.modelo;

import java.util.List;

public class CarritoBasico implements Carrito{
    private List<Producto> productos;

    public CarritoBasico(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public double calcularTotal() {
        return 100000;
    }

    @Override
    public String getDescripcion() {
        return "Carrito básico";
    }
}
