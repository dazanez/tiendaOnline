package vista;

import controlador.ControladorBase;
import controlador.FacadeController;
import controlador.FlyweightController;

public class MainController extends ControladorBase {

	public void ejecutarProxy() {
	    try {
	        openVistaModal("/proyecto/softDos/proxy.fxml", "Patrón Proxy");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public void mostrarFacade() {
        FacadeController controller = new FacadeController();
        controller.ejecutar();
    }
	public void mostrarFlyweight() {
	    FlyweightController controller = new FlyweightController();
	    controller.ejecutar();
	}
}
