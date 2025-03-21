package co.edu.poli.tiendadj.controlador;


import co.edu.poli.tiendadj.MainView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class MenuControlador extends ControladorBase {
    private MainView mainView = new MainView();

    @FXML
    void openClienteCrudScreen(ActionEvent event) throws IOException {
        MainView.loadScreenWithPath("clienteCRUD.fxml", "CRUD Cliente");
    }

    @FXML
    void openClonarProductoScreen(ActionEvent event) throws IOException {
        MainView.loadScreenWithPath("productoClonar.fxml", "Clonar Producto");
    }
}
