package co.edu.poli.tiendadj;

import co.edu.poli.tiendadj.servicio.ConnectionDB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        testConnection();
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
}