package co.edu.poli.tiendaOnline.controlador;

import co.edu.poli.tiendaOnline.modelo.Producto;
import co.edu.poli.tiendaOnline.servicio.ProductoDAO;

public class ProductoControlador {	
	public String crear(Producto producto) {
		ProductoDAO productoDAO = new ProductoDAO();
		return  productoDAO.insertar(producto);
	}
}
