package co.edu.poli.tiendadj.modelo;

import java.time.LocalDate;

public class ProductoMemento {
    private String name, description;
    private double price;
    private int stock;
    private LocalDate created_at;

    public ProductoMemento(String name, String description, double price, int stock, LocalDate created_at) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.created_at = created_at;
    }


    public boolean isDate(LocalDate date) {
        return date.isEqual(created_at);
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

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "ProductoMemento{" +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", created_at=" + created_at +
                '}';
    }
}
