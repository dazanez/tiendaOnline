package co.edu.poli.tiendadj.modelo;

public class Evaluacion {
    private String nivel;

    public Evaluacion(String nivel) {
        this.nivel = nivel;
    }

    public String getNivel() {
        return nivel;
    }

    @Override
    public String toString() {
        return "Evaluacion{" + "nivel='" + nivel + '\'' + '}';
    }
}
