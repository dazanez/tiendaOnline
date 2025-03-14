package co.edu.poli.tiendadj.modelo;

public class Producto implements Cloneable {
	private int id;
	private String descripcion;

	// Método para clonar
	@Override
	public Producto clone() {
		try {
			return (Producto) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException("Error al clonar el producto", e);
		}
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
	public Producto(int id, String description) {
		super();
		this.id = id;
		this.descripcion = description;
	}
}
