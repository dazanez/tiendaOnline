package co.edu.poli.tiendadj.modelo;

public class Proveedor {
	private final String evaluacion;
	private final String certificacion;
	private final String politicaEntrega;

	private Proveedor(Builder builder) {
		this.evaluacion = builder.evaluacion;
		this.certificacion = builder.certificacion;
		this.politicaEntrega = builder.politicaEntrega;
	}

	public static class Builder {
		private String evaluacion;
		private String certificacion;
		private String politicaEntrega;

		public Builder setEvaluacion(String evaluacion) {
			this.evaluacion = evaluacion;
			return this;
		}

		public Builder setCertificacion(String certificación) {
			this.certificacion = certificación;
			return this;
		}

		public Builder setPoliticaEntrega(String politicaEntrega) {
			this.politicaEntrega = politicaEntrega;
			return this;
		}

		public Proveedor build() {
			return new Proveedor(this);
		}
	}
	@Override
	public String toString() {
		return "Builder [evaluacion=" + evaluacion + ", certificacion=" + certificacion + ", politaEntrega="
				+ politicaEntrega + "]";
	}
}