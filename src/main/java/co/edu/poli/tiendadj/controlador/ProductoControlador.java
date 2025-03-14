package co.edu.poli.tiendadj.controlador;

import co.edu.poli.tiendadj.modelo.Producto;
import co.edu.poli.tiendadj.servicio.ProductoDAO;
import co.edu.poli.tiendadj.servicio.SpecializedDAO;

import java.sql.SQLException;
import java.util.List;

public class ProductoControlador implements SpecializedController<Producto> {

	private SpecializedDAO<Producto, Integer> productoDAO;

	public ProductoControlador() {
		try {
			this.productoDAO = (SpecializedDAO) new ProductoDAO();
		} catch (SQLException err) {
			System.err.println("Error al crear el DAO de Producto");
		}
	}

	public String create(Producto producto) {
		try {
			return productoDAO.insert(producto);
		} catch (Exception e) {
			return "❌ Error al crear el producto: " + e.getMessage();
		}
	}

	@Override
	public List<Producto> specialiezedQuery(String name) {
		try {
			return productoDAO.specializedQuery(name);
		} catch (Exception e) {
			System.out.println("❌ Error en la consulta especializada: " + e.getMessage());
			return null;
		}
	}
}
