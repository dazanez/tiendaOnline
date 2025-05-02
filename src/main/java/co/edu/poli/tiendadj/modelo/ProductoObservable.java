package co.edu.poli.tiendadj.modelo;

import java.util.ArrayList;
import java.util.List;

public class ProductoObservable extends Producto implements Subject{
	private List<Observer> observadores = new ArrayList<>();

	public ProductoObservable(String name, String description, double price, int stock) {
		super(name, description, price, stock);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void agregarObservador(Observer o) {
		observadores.add(o);
	}

	@Override
	public void eliminarObservador(Observer o) {
		observadores.remove(o);
		
	}

	@Override
	public void notificarObservadores(String mensaje) {
		for (Observer o : observadores) {
			o.update(mensaje);
		}
		
	}
	
	@Override
	public void setPrice(double price) {
		double oldPrice = getPrice();
		super.setPrice(price);
		if (price != oldPrice) {
			String mensaje = price < oldPrice ? "Descuento disponible " : "El precio ha subido";
			notificarObservadores(getName() + ": " + mensaje + " Nuevo precio $" + price);
		}
	}
}
