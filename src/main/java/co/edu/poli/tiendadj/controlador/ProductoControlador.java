package co.edu.poli.tiendadj.controlador;
import co.edu.poli.tiendadj.modelo.Producto;
import co.edu.poli.tiendadj.modelo.ProductoMemento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductoControlador extends ControladorBase {

    private final Producto producto = new Producto("Chocorramo", "Ponque con choco", 3000, 10);
    List<ProductoMemento> productosHistory = new ArrayList<>();
    boolean isEditing;

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
    private void initialize() {
        isEditing = true;

        datePicker.setValue(LocalDate.now());
        datePicker.setEditable(false);
        updateLabels();
        updateTabsButtons();
    }

    @FXML
    void onEdit(ActionEvent event) {
        isEditing = true;
        updateTabsButtons();
        nameTxt.requestFocus();
    }

    @FXML
    void OnShowHistory(ActionEvent event) {
        if (productosHistory.size() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Sin historial");
            alert.setContentText("No hay historial de productos");
            alert.show();
            return;
        }
        isEditing = false;
        updateTabsButtons();
        datePicker.requestFocus();
    }

    @FXML
    void onUpdate(ActionEvent event) {
        producto.setName(nameTxt.getText());
        producto.setDescription(descriptionTxt.getText());
        producto.setPrice(Double.parseDouble(priceTxt.getText()));
        producto.setStock(Integer.parseInt(stockTxt.getText()));
        producto.setCreatedAt(datePicker.getValue());

        ProductoMemento memento = getMementoOnDatePicker();

        if (memento == null)
            productosHistory.add(producto.createSnapshot());
        else {
            productosHistory.set(productosHistory.indexOf(memento), producto.createSnapshot());
        }

        updateLabels();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Producto actualizado");
        alert.setContentText("Se actualizó el registro para el " + datePicker.getValue());
        alert.show();
        System.out.println("Registros del producto: " + productosHistory.size());
    }

    @FXML
    void onDateChanged(ActionEvent event) {
        if (!isEditing) {
            ProductoMemento productoMemento = getMementoOnDatePicker();
            if (productoMemento != null) {
                producto.restoreFrom(productoMemento);
                updateLabels();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("No hay registros");
                alert.setContentText("No se ha encontrado historial de productos para el " + datePicker.getValue());
                alert.show();
            }
        }
    }

    void updateTabsButtons() {
        if (isEditing) {
            editBttn.setDisable(true);
            showHistoryBttn.setDisable(false);
            updateBttn.setVisible(true);
            nameTxt.setDisable(false);
            descriptionTxt.setDisable(false);
            priceTxt.setDisable(false);
            stockTxt.setDisable(false);
        } else {
            showHistoryBttn.setDisable(true);
            editBttn.setDisable(false);
            updateBttn.setVisible(false);
            nameTxt.setDisable(true);
            descriptionTxt.setDisable(true);
            priceTxt.setDisable(true);
            stockTxt.setDisable(true);
        }
    }

    void updateLabels() {
        nameTxt.setText(producto.getName());
        descriptionTxt.setText(producto.getDescription());
        priceTxt.setText(producto.getPrice() + "");
        stockTxt.setText(producto.getStock() + "");
    }

    ProductoMemento getMementoOnDatePicker() {

        for (ProductoMemento m : productosHistory) {
            if (m.isDate(datePicker.getValue())) return m;
        }

        return null;
    }
}
