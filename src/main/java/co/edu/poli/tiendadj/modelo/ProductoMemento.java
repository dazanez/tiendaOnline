package co.edu.poli.tiendadj.modelo;

import java.time.LocalDate;

public class ProductoMemento implements Memento {
    Producto producto;
    private String name, description;
    private double price;
    private int stock;
    private LocalDate created_at;

    public ProductoMemento(Producto producto, String name, String description, double price, int stock, LocalDate created_at) {
        this.producto = producto;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.created_at = created_at;
    }

    @Override
    public void restore() {
        producto.setName(name);
        producto.setDescription(description);
        producto.setStock(stock);
        producto.setPrice(price);
        producto.setCreatedAt(created_at);
    }

    public boolean isDate(LocalDate date) {
        return date.isEqual(created_at);
    }
}
