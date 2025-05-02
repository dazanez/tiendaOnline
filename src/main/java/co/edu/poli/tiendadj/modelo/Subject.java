package co.edu.poli.tiendadj.modelo;

public interface Subject {
	void agregarObservador(Observer o);
	void eliminarObservador(Observer o);
	void notificarObservadores(String mensaje);
}
