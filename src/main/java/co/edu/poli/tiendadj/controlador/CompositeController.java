package co.edu.poli.tiendadj.controlador;

import java.io.IOException;

import co.edu.poli.tiendadj.MainView;
import co.edu.poli.tiendadj.modelo.Departamento;
import co.edu.poli.tiendadj.modelo.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CompositeController extends ControladorBase {
    @FXML private TreeView<String> treeView;

    private TreeItem<String> raiz;
    private Departamento empresa;

    @FXML
    public void initialize() {
        empresa = new Departamento("Empresa");
        raiz = new TreeItem<>("🏢 " + empresa.getNombre());
        treeView.setRoot(raiz);
    }

    @FXML
    private void agregarDepartamento() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Nuevo Departamento");
        dialog.setHeaderText("Agregar Departamento");
        dialog.setContentText("Nombre:");

        dialog.showAndWait().ifPresent(nombre -> {
            Departamento nuevoDep = new Departamento(nombre);
            empresa.agregar(nuevoDep);
            TreeItem<String> nuevoItem = new TreeItem<>("🏢 " + nuevoDep.getNombre());
            raiz.getChildren().add(nuevoItem);
        });
    }

    @FXML
    private void agregarEmpleado() {
        TreeItem<String> departamentoSeleccionado = treeView.getSelectionModel().getSelectedItem();

        if (departamentoSeleccionado == null || departamentoSeleccionado.getParent() == null) {
            Alert alerta = new Alert(Alert.AlertType.WARNING, "Seleccione un departamento antes de agregar un empleado.");
            alerta.show();
            return;
        }

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Nuevo Empleado");
        dialog.setHeaderText("Agregar Empleado");
        dialog.setContentText("Nombre y Puesto (Ej: Juan - Ingeniero):");

        dialog.showAndWait().ifPresent(datos -> {
            String[] partes = datos.split("-");
            if (partes.length == 2) {
                Empleado nuevoEmp = new Empleado(partes[0].trim(), partes[1].trim());
                
                // Agregar empleado dentro del departamento seleccionado
                TreeItem<String> nuevoItem = new TreeItem<>("" + nuevoEmp.getNombre());
                departamentoSeleccionado.getChildren().add(nuevoItem);
            }
        });
    }
    @FXML
	void openMenuScreen1(ActionEvent event) throws IOException {
		MainView.loadScreenWithPath("menu.fxml", "Menu");
	}

}
