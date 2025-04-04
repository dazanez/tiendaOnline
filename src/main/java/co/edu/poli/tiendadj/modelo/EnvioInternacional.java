package co.edu.poli.tiendadj.modelo;

public class EnvioInternacional extends Envio {
	public EnvioInternacional(Mercancia mercancia) {
		super(mercancia);
	}

	@Override
	public String enviar() {
		// TODO Auto-generated method stub
		return "Envio internacional: " + mercancia.entregar();
	}

}
