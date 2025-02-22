package co.edu.poli.tiendaOnline.controlador;

public interface SpecializedController<T> extends ControllerTemp<T>{
    public T specialiezedQuery(String name);
}
