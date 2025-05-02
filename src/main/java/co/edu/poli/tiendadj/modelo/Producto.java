package co.edu.poli.tiendadj.modelo;

import java.time.LocalDate;

// Clase abstracta Producto
public class Producto {
	private String name, description;
	private double price;
	private int stock;
	private LocalDate createdAt;

	public Producto(String name, String description, double price, int stock, LocalDate createdAt) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.createdAt = createdAt;
	}

	public Producto(String name, String description, double price, int stock) {
		this(name, description, price, stock, LocalDate.now());
	}

	public ProductoMemento createSnapshot() {
		return new ProductoMemento(name, description, price, stock, createdAt);
	}

	public void restoreFrom(ProductoMemento memento) {
		this.name = memento.getName();
		this.description = memento.getDescription();
		this.price = memento.getPrice();
		this.stock = memento.getStock();
		this.createdAt = memento.getCreated_at();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Producto{" +
				"name='" + name + '\'' +
				", description='" + description + '\'' +
				", price=" + price +
				", stock=" + stock +
				", createdAt=" + createdAt +
				'}';
	}


}
