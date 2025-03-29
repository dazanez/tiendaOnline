package co.edu.poli.tiendadj.modelo;

public class Certificacion {
    private String tipo;

    public Certificacion(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }
}