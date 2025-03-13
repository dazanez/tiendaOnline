package co.edu.poli.tiendadj.modelo;

import java.time.LocalDate;
import java.util.List;

public class Pedido {
	private String calle;
	private LocalDate fecha;
	private String ciudad;
	private List<Producto> productos;
	private Cliente cliente;
	private int id;

	public Pedido(String calle, LocalDate fecha, String ciudad, List<Producto> producto, Cliente cliente, int id) {
		super();
		this.calle = calle;
		this.fecha = fecha;
		this.ciudad = ciudad;
		this.productos = producto;
		this.cliente = cliente;
		this.setId(id);
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProducto(List<Producto> producto) {
		this.productos = producto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Pedido \nCalle:" + calle + " \nFecha:" + fecha + "\nCiudad=" + ciudad + "\nProducto=" + productos
				+ "\nCliente=" + cliente + "]";
	}

}
