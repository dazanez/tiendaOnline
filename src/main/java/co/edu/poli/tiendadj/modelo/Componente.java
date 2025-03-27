package co.edu.poli.tiendadj.modelo;

public interface Componente {
	String getNombre();

	default String getPuesto() {
		return "";
	}
}
