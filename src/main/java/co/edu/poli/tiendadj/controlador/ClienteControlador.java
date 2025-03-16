package co.edu.poli.tiendadj.controlador;

import co.edu.poli.tiendadj.modelo.Cliente;
import co.edu.poli.tiendadj.servicio.ClienteDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class ClienteControlador implements ControllerTemp<Cliente> {
	int id = 0;

	public String create(Cliente cliente) {
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			return clienteDAO.insert(cliente);
		} catch (SQLException e) {
			return "Error al insertar cliente: " + e.getMessage();
		}
	}
	@FXML
	private Button updateCliente;

	@FXML
	private TextField idCliente;

	@FXML
	private Button deleteClienteById;

	@FXML
	private Button getClienteById;

	@FXML
	private TextField nombre;

	@FXML
	private TextField edad;

	@FXML
	private TextField email;

	@FXML
	private Button insertCliente;

	@FXML
	void insertCliente(ActionEvent event) {
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			Cliente c = new Cliente(getNextId(), nombre.getText(), email.getText(), Integer.parseInt(edad.getText()));
			clienteDAO.insert(c);
			Alert a = new Alert(Alert.AlertType.CONFIRMATION);
			a.setTitle("Actuaizacion de cliente exitosa");
			a.setContentText(c.toString());
			a.show();
		} catch (SQLException e) {
			Alert a = new Alert(Alert.AlertType.CONFIRMATION);
			a.setContentText("Error al crear el cliente");
			a.show();
		}
	}

	@FXML
	void getClienteById(ActionEvent event) {
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			Cliente c = clienteDAO.getById(Integer.parseInt(idCliente.getText()));
			Alert a = new Alert(Alert.AlertType.CONFIRMATION);
			a.setTitle("Consulta de cliente");
			a.setContentText(c.toString());
			a.show();
		} catch (Exception e) {
			Alert a = new Alert(Alert.AlertType.CONFIRMATION);
			a.setContentText("Error al obtener el cliente");
			System.err.println(e.getMessage());
			a.show();
		}
	}

	@FXML
	void updateCliente(ActionEvent event) {
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			Cliente c = new Cliente(Integer.parseInt(idCliente.getText()), nombre.getText(), email.getText(), Integer.parseInt(edad.getText()));
			clienteDAO.update(c);
			Alert a = new Alert(Alert.AlertType.CONFIRMATION);
			a.setTitle("Actualizacion de cliente exitosa");
			a.setContentText(c.toString());
			a.show();
		} catch (Exception e) {
			Alert a = new Alert(Alert.AlertType.CONFIRMATION);
			a.setContentText("Error al actualizar el cliente");
			System.err.println(e.getMessage());
			a.show();
		}
	}

	@FXML
	void deleteClienteById(ActionEvent event) {
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			String msg = clienteDAO.delete(Integer.parseInt(idCliente.getText()));
			Alert a = new Alert(Alert.AlertType.CONFIRMATION);
			a.setTitle("Eliminacion de cliente");
			a.setContentText(msg);
			a.show();
		} catch (Exception e) {
			Alert a = new Alert(Alert.AlertType.CONFIRMATION);
			a.setContentText("Error al actualizar el cliente");
			System.err.println(e.getMessage());
			a.show();
		}
	}

	private int getNextId() {
		return id++;
	}
}
