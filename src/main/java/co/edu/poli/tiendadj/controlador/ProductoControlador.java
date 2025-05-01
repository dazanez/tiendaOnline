package co.edu.poli.tiendadj.controlador;
import co.edu.poli.tiendadj.modelo.Producto;
import co.edu.poli.tiendadj.modelo.ProductoMemento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class ProductoControlador extends ControladorBase {

    private Producto producto;
    List<ProductoMemento> productosHistory = new ArrayList<>();
    boolean isEditing;

    @FXML
    private void initialize() {
        isEditing = true;
        producto = new Producto("Chocorramo", "Ponque con choco", 3000, 10);

        nameTxt.setText(producto.getName());
        descriptionTxt.setText(producto.getDescription());
        priceTxt.setText(producto.getPrice() + "");
        stockTxt.setText(producto.getStock() + "");
        datePicker.setValue(producto.getCreatedAt());

        updateTabsButtons();
    }

    @FXML
    private Button updateBttn;

    @FXML
    private TextField stockTxt;

    @FXML
    private Button editBttn;

    @FXML
    private TextField nameTxt;

    @FXML
    private Button showHistoryBttn;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField priceTxt;

    @FXML
    private TextArea descriptionTxt;

    @FXML
    void onEdit(ActionEvent event) {
        updateTabsButtons();
        nameTxt.requestFocus();
    }

    @FXML
    void OnShowHistory(ActionEvent event) {
        if (productosHistory.size() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("No hay historial de productos");
            alert.show();
            return;
        }
        isEditing = false;
        updateTabsButtons();
    }

    @FXML
    void onUpdate(ActionEvent event) {
        productosHistory.add(producto.createSnapshot());
    }

    void updateTabsButtons() {
        if (isEditing) {
            editBttn.setDisable(true);
            showHistoryBttn.setDisable(false);
            updateBttn.setVisible(false);
            nameTxt.setEditable(true);
            descriptionTxt.setEditable(true);
            priceTxt.setEditable(true);
            stockTxt.setEditable(true);
        } else {
            showHistoryBttn.setDisable(true);
            editBttn.setDisable(false);
            updateBttn.setVisible(true);
            nameTxt.setEditable(false);
            descriptionTxt.setEditable(false);
            priceTxt.setEditable(false);
            stockTxt.setEditable(false);
        }
    }

}
