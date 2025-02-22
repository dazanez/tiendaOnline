package co.edu.poli.tiendaOnline.controlador;

import co.edu.poli.tiendaOnline.modelo.Pedido;
import co.edu.poli.tiendaOnline.servicio.PedidoDAO;

public class PedidoControlador implements ControllerTemp<Pedido> {
	public String create(Pedido pedido) {
		PedidoDAO PedidoDAO = new PedidoDAO();
		return  PedidoDAO.insertar(pedido);
	}
}
