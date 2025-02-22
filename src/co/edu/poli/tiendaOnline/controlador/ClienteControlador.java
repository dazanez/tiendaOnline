package co.edu.poli.tiendaOnline.controlador;

import co.edu.poli.tiendaOnline.modelo.Cliente;
import co.edu.poli.tiendaOnline.servicio.ClienteDAO;

public class ClienteControlador implements ControllerTemp<Cliente> {
	public String create(Cliente cliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		return  clienteDAO.insertar(cliente);
	}
}
