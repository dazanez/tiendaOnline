package co.edu.poli.tiendadj.modelo;

public class Producto {
	private int id;
	private String descripcion;

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
