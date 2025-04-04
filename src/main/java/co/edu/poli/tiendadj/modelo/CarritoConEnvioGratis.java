package co.edu.poli.tiendadj.modelo;

public class CarritoConEnvioGratis extends CarritoDecorator {
    private double costoEnvio;

    public CarritoConEnvioGratis(Carrito carrito, double costoEnvio) {
        super(carrito);
        this.costoEnvio = costoEnvio;
    }

    @Override
    public double calcularTotal() {
        return super.calcularTotal() - costoEnvio;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Envío gratis";
    }
}

