package co.edu.poli.tiendadj.modelo;

public class PoliticaEntrega {
	private String politica;

	public PoliticaEntrega(String politica) {
		this.politica = politica;
	}

	public String getPolitica() {
		return politica;
	}

	@Override
	public String toString() {
		return "PoliticaEntrega{" + "politica='" + politica + '\'' + '}';
	}
}