package co.edu.poli.tiendadj.controlador;

import co.edu.poli.tiendadj.modelo.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class CarritoController extends ControladorBase{

    @FXML
    private CheckBox chkPuntos;

    @FXML
    private TextField txtDescuento;

    @FXML
    private TextField txtEnvioGratis;

    @FXML
    private CheckBox chkDescuento;

    @FXML
    private CheckBox chkEnvioGratis;

    @FXML
    private TextArea txtDescripcion;

    @FXML
    void calcularCarrito(ActionEvent event) {
        List<Producto> productos = new ArrayList<>();
        productos.add(new ProductoAlimenticio(2, "Chocorramo", 100));
        productos.add(new ProductoElectrico(1, "Nevera", 120));
        Carrito carrito = new CarritoBasico(productos);
        if (chkDescuento.isSelected()) carrito = new CarritoConDescuento(carrito, Double.parseDouble(txtDescuento.getText())/100);
        if (chkEnvioGratis.isSelected()) carrito = new CarritoConEnvioGratis(carrito, Double.parseDouble(txtEnvioGratis.getText()));
        if (chkPuntos.isSelected()) carrito = new CarritoConPuntos(carrito);
        txtDescripcion.setText(carrito.getDescripcion() + "\nTotal:" + carrito.calcularTotal());
    }

}

