package MODEL;

import UTIL.Entidad;

public class Curso implements Entidad<String> {
    private String codigo;
    private String nombre;

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    @Override
    public String getId() {
        return codigo;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Curso: " + nombre + " (Código: " + codigo + ")");
    }

    // Getters y setters si querés
}
