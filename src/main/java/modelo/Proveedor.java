package modelo;

public class Proveedor {
	private String nombre;

    public Proveedor(String nombre) {
        this.nombre = nombre;
    }

    public void mostrar() {
        System.out.println("Proveedor: " + nombre);
    }
}
