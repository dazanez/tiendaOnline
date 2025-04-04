package co.edu.poli.tiendadj.modelo;

public class EnvioNacional extends Envio {
	
	public EnvioNacional(Mercancia mercancia) {
		super(mercancia);
	}

	@Override
	public String enviar() {
		// TODO Auto-generated method stub
		return "Envio Nacional: " + mercancia.entregar();
	}

}
