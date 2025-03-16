package co.edu.poli.tiendadj.controlador;

import co.edu.poli.tiendadj.MainView;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class ControladorBase {
    protected Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void openMenu() throws IOException {
        MainView.loadScreenWithPath("menu.fxml", "Menu");
    }
}
