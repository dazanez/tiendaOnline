package controlador;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ControladorBase {

    /**
     * Abre una vista principal en una nueva ventana (Scene) no modal.
     *
     * @param rutaFXML Ruta al archivo FXML
     * @param titulo   Título de la ventana
     */
    public void openVista(String rutaFXML, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Abre una vista en una ventana emergente (modal), útil para formularios o interacciones específicas.
     *
     * @param rutaFXML Ruta al archivo FXML
     * @param titulo   Título de la ventana modal
     */
    public void openVistaModal(String rutaFXML, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL); // Bloquea la ventana principal
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
