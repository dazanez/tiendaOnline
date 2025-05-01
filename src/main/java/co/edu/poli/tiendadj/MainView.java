package co.edu.poli.tiendadj;

import co.edu.poli.tiendadj.controlador.ControladorBase;
import co.edu.poli.tiendadj.servicio.ConnectionDB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

public class MainView extends Application {
    private static Stage appStage;

    @Override
    public void start(Stage stage) throws IOException {
        appStage = stage;

        loadScreenWithPath("menu.fxml", "Menu");
    }

    public static void main(String[] args) {
        launch();
    }

    private void loadClienteCRUD(Stage stage) throws IOException {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/co/edu/poli/tiendadj/vista/clienteCRUD.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("CRUD Cliente!");
        stage.setScene(scene);
        stage.show();
    }

    public static void loadScreenWithPath(String path, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getResourceFor(path));
            AnchorPane root = loader.load();
            Scene scene = new Scene(root);
            appStage.setTitle(title);
            appStage.setScene(scene);
            appStage.show();

            // Pasa el Stage al controlador
            ControladorBase controlador = loader.getController();
            controlador.setStage(appStage);
        }
        catch (IOException err) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(err.getMessage());
            alert.show();
            err.printStackTrace();
        }
    }

    private static URL getResourceFor(String filename) {
        return MainView.class.getResource("/co/edu/poli/tiendadj/vista/" + filename);
    }

    private static void testConnection() {
        try {
            ConnectionDB.getConnection();
            // Cerrar la conexión al final del programa
            ConnectionDB.closeConnection();
        } catch (SQLException err) {
            System.out.println("Ocurrió un error al conectar a la BD");
            System.err.println(err.getMessage());
        }
    }
}