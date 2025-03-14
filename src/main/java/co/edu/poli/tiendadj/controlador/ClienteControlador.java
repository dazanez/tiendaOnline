package co.edu.poli.tiendadj.controlador;

import co.edu.poli.tiendadj.modelo.Cliente;
import co.edu.poli.tiendadj.servicio.ClienteDAO;

import java.sql.SQLException;

public class ClienteControlador implements ControllerTemp<Cliente> {

	public String create(Cliente cliente) {
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			return clienteDAO.insert(cliente);
		} catch (SQLException e) {
			return "Error al insertar cliente: " + e.getMessage();
		}
	}
}
