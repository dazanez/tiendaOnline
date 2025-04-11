package controlador;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import modelo.ClienteFacade;

public class FacadeController extends ControladorBase {

    @FXML private TextArea resultadoArea;
    private ClienteFacade fachada = new ClienteFacade();

    public void ejecutar() {
        openVistaModal("/proyecto/softDos/facade.fxml", "Facade - Cliente");
    }

    public void mostrarInformacion() {
        resultadoArea.setText(fachada.mostrarInformacion());
    }

    public void mostrarHistorial() {
        resultadoArea.setText(fachada.mostrarHistorialPedidos());
    }

    public void mostrarFormasPago() {
        resultadoArea.setText(fachada.mostrarFormasPago());
    }
}
