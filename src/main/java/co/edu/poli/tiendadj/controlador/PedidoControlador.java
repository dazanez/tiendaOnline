package co.edu.poli.tiendadj.controlador;

import co.edu.poli.tiendadj.modelo.Pedido;
import co.edu.poli.tiendadj.servicio.PedidoDAO;

import java.sql.SQLException;

public class PedidoControlador implements ControllerTemp<Pedido> {
	public String create(Pedido pedido) {
		try {
			PedidoDAO PedidoDAO = new PedidoDAO();
			return PedidoDAO.insert(pedido);
		} catch (SQLException err) {
			return "Error al crear el pedido";
		}
	}
}
