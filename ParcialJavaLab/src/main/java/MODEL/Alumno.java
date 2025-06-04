package MODEL;

import UTIL.Entidad;

public class Alumno implements Entidad<Integer> {
    private Integer id;
    private String nombre;

    public Alumno(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Alumno: " + nombre + " (ID: " + id + ")");
    }

    public String getNombre() {
        return nombre;
    }

    // Getters y setters si querés
}

