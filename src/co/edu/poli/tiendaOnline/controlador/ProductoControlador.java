package co.edu.poli.tiendaOnline.controlador;

import co.edu.poli.tiendaOnline.modelo.Producto;
import co.edu.poli.tiendaOnline.servicio.ProductoDAO;
import co.edu.poli.tiendaOnline.servicio.SpecializedDAO;

public class ProductoControlador implements SpecializedController<Producto> {

	private SpecializedDAO<Producto, Integer> productoDAO = new ProductoDAO();

	public String create(Producto producto) {
		return  productoDAO.insertar(producto);
	}

	@Override
	public Producto specialiezedQuery(String name) {
		return productoDAO.specializedQuery(name);
	}
}
