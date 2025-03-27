package co.edu.poli.tiendadj.modelo;

import java.util.ArrayList;
import java.util.List;

public class Departamento implements Componente {
    private String nombre;
    private List<Componente> componentes; // Contendrá empleados o sub-departamentos

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.componentes = new ArrayList<>();
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    // ✔ MÉTODO PARA AGREGAR COMPONENTES
    public void agregar(Componente componente) {
        componentes.add(componente);
    }

    public List<Componente> getComponentes() {
        return componentes;
    }
}


