package co.edu.poli.tiendadj.controlador;

import co.edu.poli.tiendadj.modelo.Producto;
import co.edu.poli.tiendadj.modelo.adapters.NequiAdapter;
import co.edu.poli.tiendadj.modelo.adapters.PaypalAdapter;
import co.edu.poli.tiendadj.modelo.interfaces.ProcesadorPago;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class ControladorPago extends ControladorBase {

    enum MetodosPago {NEQUI, PAYPAL}
    MetodosPago metodo = MetodosPago.NEQUI;

    @FXML
    private TextField montoPago;

    @FXML
    private TextField cuenta;

    @FXML
    void pagarNequi(ActionEvent event) {
        metodo = MetodosPago.NEQUI;
        procesarPago();
    }

    @FXML
    void pagarPaypal(ActionEvent event) {
        metodo = MetodosPago.PAYPAL;
        procesarPago();
    }
    void procesarPago() {
        ProcesadorPago procesadorPago;
        String cuentaPago = cuenta.getText();
        if (metodo == MetodosPago.NEQUI)
            procesadorPago = new NequiAdapter(cuentaPago);
        else if (metodo == MetodosPago.PAYPAL) {
            procesadorPago = new PaypalAdapter(cuentaPago);
        }
        else {
            System.out.println("Metodo pago no soportado");
            return;
        }

        try {
            procesadorPago.procesarPago(Double.parseDouble(montoPago.getText()));
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setTitle("Pago realizado");
            a.setContentText("Se realizó el pago con " + metodo.name() + " por $" + montoPago.getText() + "\nCuenta: " + cuenta.getText());
            a.show();
        }
        catch (Exception err) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error al realizar pago");
            a.setContentText(err.getMessage());
            a.show();
        }
    }
}
