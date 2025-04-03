package co.edu.poli.tiendadj.controlador;

import co.edu.poli.tiendadj.modelo.CargaFragil;
import co.edu.poli.tiendadj.modelo.CargaNormal;
import co.edu.poli.tiendadj.modelo.Documentos;
import co.edu.poli.tiendadj.modelo.Envio;
import co.edu.poli.tiendadj.modelo.EnvioInternacional;
import co.edu.poli.tiendadj.modelo.EnvioNacional;
import co.edu.poli.tiendadj.modelo.Mercancia;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;


public class EnvioController extends ControladorBase {

    @FXML
    private ComboBox<String> cbEnvio;

    @FXML
    private ComboBox<String> cbMercancia;

    @FXML
    private Label lblResultado;

    @FXML
    public void initialize() {
        // Agregar opciones a los ComboBox
        cbEnvio.getItems().addAll("Nacional", "Internacional");
        cbMercancia.getItems().addAll("Documentos", "Carga Normal", "Carga Frágil");
    }

    @FXML
    public void procesarEnvio() {
        String tipoEnvio = cbEnvio.getValue();
        String tipoMercancia = cbMercancia.getValue();

        if (tipoEnvio == null || tipoMercancia == null) {
            lblResultado.setText("Seleccione todas las opciones.");
            return;
        }

        Mercancia mercancia;
        switch (tipoMercancia) {
            case "Documentos":
                mercancia = new Documentos();
                break;
            case "Carga Normal":
                mercancia = new CargaNormal();
                break;
            case "Carga Frágil":
                mercancia = new CargaFragil();
                break;
            default:
                lblResultado.setText("Opción no válida.");
                return;
        }

        Envio envio;
        if (tipoEnvio.equals("Nacional")) {
            envio = new EnvioNacional(mercancia);
        } else {
            envio = new EnvioInternacional(mercancia);
        }

        lblResultado.setText(envio.enviar());
    }
}