package co.edu.poli.tiendadj.modelo;

public class Empleado implements Componente {
	private String nombre;
	private String puesto;

	public Empleado(String nombre, String puesto) {
		super();
		this.nombre = nombre;
		this.puesto = puesto;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return "👤 " + nombre + " (" + puesto + ")";
	}
    @Override
    public String getPuesto() {
        return puesto;
    }
}
