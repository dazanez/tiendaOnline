package co.edu.poli.tiendadj.modelo;

public class EnvioExpress extends Envio{
	
	public EnvioExpress(Mercancia mercancia) {
		super(mercancia);
	}


	@Override
	public String enviar() {
		// TODO Auto-generated method stub
		return "Envio Express: " + mercancia.entregar();
	}

}
