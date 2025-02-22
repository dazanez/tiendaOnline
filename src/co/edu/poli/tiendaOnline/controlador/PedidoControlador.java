package co.edu.poli.tiendaOnline.controlador;

import co.edu.poli.tiendaOnline.modelo.Pedido;
import co.edu.poli.tiendaOnline.servicio.PedidoDAO;

public class PedidoControlador {	
	public String crear(Pedido pedido) {
		PedidoDAO PedidoDAO = new PedidoDAO();
		return  PedidoDAO.insertar(pedido);
	}
}
