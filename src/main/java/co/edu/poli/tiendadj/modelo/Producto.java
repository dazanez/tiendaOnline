package co.edu.poli.tiendadj.modelo;

import java.time.LocalDate;

// Clase abstracta Producto
public class Producto {
	private String name, description;
	private double price;
	private int stock;
	private LocalDate createdAt;

	public Producto(String name, String description, double price, int stock) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.createdAt = LocalDate.now();
	}

	public ProductoMemento createSnapshot() {
		return new ProductoMemento(this, name, description, price, stock, createdAt);
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
}
