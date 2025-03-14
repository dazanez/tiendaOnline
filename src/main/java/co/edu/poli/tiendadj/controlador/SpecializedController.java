package co.edu.poli.tiendadj.controlador;

import java.util.List;

public interface SpecializedController<T> extends ControllerTemp<T>{
    public List<T> specialiezedQuery(String name);
}
