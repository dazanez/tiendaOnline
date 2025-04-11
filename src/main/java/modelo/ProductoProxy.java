package modelo;

public class ProductoProxy implements Producto{
	private String rol;
	private ProductoReal productoReal;
	
	
	public ProductoProxy(String rol) {
		this.rol = rol;
		this.productoReal = new ProductoReal();
	}


	@Override
	public void mostrarDetalles() {
		if (rol.equals("admin")) {
			productoReal.mostrarDetalles();
		}else {
			System.out.println("Acceso denegado: nivel de autorización insuficiente");
		}
	}

}
