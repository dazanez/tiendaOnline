package co.edu.poli.tiendadj.modelo;

import co.edu.poli.tiendadj.controlador.ObserverController;

public class Usuario implements Observer {
    private String nombre;
    private ObserverController controller;

    public Usuario(String nombre, ObserverController controller) {
        this.nombre = nombre;
        this.controller = controller;
    }

	@Override
	public void update(String mensaje) {
		controller.mostrarNotificacion(nombre + " recibio la notificación " + mensaje);
		
	}

	public String getNombre() {
		return nombre;
	}
}
