package co.edu.poli.tiendaOnline.servicio;

public interface SpecializedDAO<T, t> extends DAO<T, t> {
    public T specializedQuery(String name);
}
