package co.edu.poli.tiendadj.modelo;

public abstract class Envio {
	protected Mercancia mercancia;

	public Envio(Mercancia mercancia) {
		this.mercancia = mercancia;
	}

	public abstract String enviar();
}
