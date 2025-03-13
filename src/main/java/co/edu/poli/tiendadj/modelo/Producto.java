package co.edu.poli.tiendaOnline.modelo;

public class Producto {
	@Override
	public String toString() {
		return "Producto [id=" + id + ", descripcion=" + description + "]";
	}
	public Producto(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private int id;
	private String description;
}
