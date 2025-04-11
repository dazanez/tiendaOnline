package controlador;

import modelo.ClienteFacade;
import modelo.FormasPagoManager;
import modelo.HistorialPedidosManager;
import modelo.InformacionPersonalManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class FacadeController extends ControladorBase {

    @FXML private TextArea resultadoArea;
    private ClienteFacade fachada = new ClienteFacade(new InformacionPersonalManager(), new HistorialPedidosManager(), new FormasPagoManager());

    public void ejecutar() {
        openVistaModal("/proyecto/softDos/facade.fxml", "Facade - Cliente");
    }

    public void mostrarTodo() {
        resultadoArea.setText(fachada.mostrarTodo());
    }
}