package co.edu.poli.tiendadj;

import co.edu.poli.tiendadj.servicio.ConnectionDB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        loadClienteCRUD(stage);
        loadProductoClonar(stage);
//        testConnection();
    }

    public static void main(String[] args) {
        launch();
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

    private void loadClienteCRUD(Stage stage) throws IOException {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/co/edu/poli/tiendadj/vista/clienteCRUD.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    private void loadProductoClonar(Stage stage) throws IOException {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/co/edu/poli/tiendadj/vista/productoClonar.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Clonar producto");
        stage.setScene(scene);
        stage.show();
    }
}