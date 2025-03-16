package co.edu.poli.tiendadj.modelo;

// Clase abstracta Producto
public abstract class Producto implements ProductoPrototype {
	private int id;
	private String descripcion;

	public Producto(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", descripcion=" + descripcion + "]";
	}

	// Método abstracto para forzar la implementación en las subclases
	@Override
	public abstract Producto clonar();
}
