package co.edu.poli.tiendadj.controlador;

import co.edu.poli.tiendadj.modelo.Producto;
import co.edu.poli.tiendadj.modelo.ProductoAlimenticio;
import co.edu.poli.tiendadj.modelo.ProductoElectrico;
import co.edu.poli.tiendadj.servicio.ProductoDAO;
import co.edu.poli.tiendadj.servicio.SpecializedDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.List;

public class ProductoControlador extends ControladorBase {

	private SpecializedDAO<Producto, Integer> productoDAO;
	private ProductoElectrico productoElectrico;
	private ProductoAlimenticio productoAlimenticio;


	public ProductoControlador() throws SQLException {
		try {
			productoDAO = (SpecializedDAO) new ProductoDAO();
			productoElectrico = new ProductoElectrico(123, "Nevera", 120);
			productoDAO.insert(productoElectrico);
			productoAlimenticio = new ProductoAlimenticio(345, "Chocorramo", 120);
			productoDAO.insert(productoAlimenticio);
		} catch (SQLException err) {
			System.err.println("Error al crear el DAO de Producto: " + err.getMessage());

		}
	}

	public String create(Producto producto) {
		try {
			return productoDAO.insert(producto);
		} catch (Exception e) {
			return "❌ Error al crear el producto: " + e.getMessage();
		}
	}

		@FXML
		private Button CloneProducto;

		@FXML
		private TextField idProducto;

		@FXML
		private Button getProductoById;

		private Producto producto;
		@FXML
		void getProductoById(ActionEvent event) {
			try {
				producto = productoDAO.getById(Integer.parseInt(idProducto.getText()));
				Alert a = new Alert(Alert.AlertType.CONFIRMATION);
				a.setTitle("Consulta de producto");
				a.setContentText(producto.toString());
				a.show();
			} catch (Exception err) {
				System.err.println("Error al consultar producto");
				Alert a = new Alert(Alert.AlertType.ERROR);
				a.setTitle("Error al consultar producto");
				a.setContentText(err.getMessage());
				a.show();
			}
		}

		@FXML
		void CloneProducto(ActionEvent event) {
			try {
				producto = productoDAO.getById(Integer.parseInt(idProducto.getText()));
				Producto productoClonado = producto.clonar();
				productoDAO.insert(productoClonado);
				Alert a = new Alert(Alert.AlertType.CONFIRMATION);
				a.setTitle("Clonación de producto");
				a.setContentText(productoClonado.toString());
				a.show();
			} catch (Exception err) {
				Alert a = new Alert(Alert.AlertType.ERROR);
				a.setTitle("Error clonando el producto");
				a.setContentText(err.getMessage());
				a.show();
			}
		}

}
