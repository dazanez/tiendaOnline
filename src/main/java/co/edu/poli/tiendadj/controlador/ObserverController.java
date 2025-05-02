package co.edu.poli.tiendadj.controlador;

import co.edu.poli.tiendadj.modelo.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class ObserverController extends ControladorBase{

    @FXML
    private TextField txtNombreUsuario;

    @FXML
    private TextField txtNuevoPrecio;

    @FXML
    private Button btnSuscribirse;

    @FXML
    private Button btnDesuscribirse;

    @FXML
    private Button btnActualizarPrecio;

    @FXML
    private TextArea areaNotificaciones;

    @FXML
    private ListView<String> listaSuscritos;

    private ProductoObservable producto;
    private List<Usuario> usuariosSuscritos;

    @FXML
    public void initialize() {
        producto = new ProductoObservable("Mouse Gamer", "Mouse RGB", 100.0, 10);
        usuariosSuscritos = new ArrayList<>();
        areaNotificaciones.setEditable(false);
    }

    @FXML
    private void suscribirse() {
        String nombre = txtNombreUsuario.getText().trim();
        if (!nombre.isEmpty()) {
            Usuario usuario = new Usuario(nombre, this);
            producto.agregarObservador(usuario);
            usuariosSuscritos.add(usuario);
            listaSuscritos.getItems().add(nombre);
            areaNotificaciones.appendText(nombre + " se ha suscrito.\n");
            txtNombreUsuario.clear();
        }
    }

    @FXML
    private void desuscribirse() {
        String nombre = txtNombreUsuario.getText().trim();
        if (!nombre.isEmpty()) {
            Usuario usuarioAEliminar = usuariosSuscritos.stream()
                    .filter(u -> u.getNombre().equals(nombre))
                    .findFirst().orElse(null);

            if (usuarioAEliminar != null) {
                producto.eliminarObservador(usuarioAEliminar);
                usuariosSuscritos.remove(usuarioAEliminar);
                listaSuscritos.getItems().remove(nombre);
                areaNotificaciones.appendText(nombre + " se ha desuscrito.\n");
                txtNombreUsuario.clear();
            }
        }
    }

    @FXML
    private void actualizarPrecio() {
        try {
            double nuevoPrecio = Double.parseDouble(txtNuevoPrecio.getText().trim());
            producto.setPrice(nuevoPrecio);
            txtNuevoPrecio.clear();
        } catch (NumberFormatException e) {
            areaNotificaciones.appendText("Precio inválido.\n");
        }
    }

    // Método para que los usuarios impriman mensajes en el área de notificaciones
    public void mostrarNotificacion(String mensaje) {
        areaNotificaciones.appendText(mensaje + "\n");
    }
}
