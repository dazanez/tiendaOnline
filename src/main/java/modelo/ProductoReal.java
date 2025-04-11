package modelo;

public class ProductoReal implements Producto {

	@Override
	public void mostrarDetalles() {
		System.out.println("Detalles de producto: Nombre, precio, descripción...");
	}

}
