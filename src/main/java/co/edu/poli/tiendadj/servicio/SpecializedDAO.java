package co.edu.poli.tiendadj.servicio;

import java.util.List;

public interface SpecializedDAO<T, t> extends DAO<T, t> {
    public List<T> specializedQuery(String name);
}
