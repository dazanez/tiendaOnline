	package co.edu.poli.tiendaOnline.servicio;
	
	import java.util.List;
	
	// Interfaz genérica CRUD para cualquier entidad (T)
	public interface DAO<T, t> {
	    String insertar(T entidad);
	    T obtenerPorId(t id);
	    List<T> obtenerTodos();
	    String actualizar(T entidad);
	    String eliminar(t id);
	}
	 