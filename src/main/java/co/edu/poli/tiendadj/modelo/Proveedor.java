package co.edu.poli.tiendadj.modelo;

public class Proveedor {
    private final Evaluacion evaluacion;
    private final Certificacion certificacion;
    private final PoliticaEntrega politicaEntrega;

    private Proveedor(Builder builder) {
        this.evaluacion = builder.evaluacion;
        this.certificacion = builder.certificacion;
        this.politicaEntrega = builder.politicaEntrega;
    }

    public static class Builder {
        private Evaluacion evaluacion;
        private Certificacion certificacion;
        private PoliticaEntrega politicaEntrega;

        public Builder setEvaluacion(Evaluacion evaluacion) {
            this.evaluacion = evaluacion;
            return this;
        }

        public Builder setCertificacion(Certificacion certificacion) {
            this.certificacion = certificacion;
            return this;
        }

        public Builder setPoliticaEntrega(PoliticaEntrega politicaEntrega) {
            this.politicaEntrega = politicaEntrega;
            return this;
        }

        public Proveedor build() {
            return new Proveedor(this);
        }
    }

    @Override
    public String toString() {
        return "Proveedor:\n" +
               "- Evaluación: " + (evaluacion != null ? evaluacion.getNivel() : "No asignada") + "\n" +
               "- Certificación: " + (certificacion != null ? certificacion.getTipo() : "No asignada") + "\n" +
               "- Política de Entrega: " + (politicaEntrega != null ? politicaEntrega.getPolitica() : "No asignada");
    }

}