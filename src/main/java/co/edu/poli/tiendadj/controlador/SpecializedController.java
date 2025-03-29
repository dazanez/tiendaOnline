package co.edu.poli.tiendadj.controlador;

import java.util.List;

public interface SpecializedController<T>{
    public List<T> specialiezedQuery(String name);
}
