package co.edu.poli.tiendadj.controlador;


import co.edu.poli.tiendadj.MainView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class MenuControlador extends ControladorBase {
    private MainView mainView = new MainView();

    @FXML
    void openProductoScreen(ActionEvent event) throws IOException {
        MainView.loadScreenWithPath("producto.fxml", "Producto Memento");
    }

    @FXML
    void openObserverScreen(ActionEvent event) throws IOException {
       MainView.loadScreenWithPath("observer.fxml", "Observer");
    }
}
