package modelo;

public class Director {
    private String nombre;
    private String apellidos;
    private boolean oscarGanado;

    public Director(String nombre, String apellidos, boolean oscarGanado) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.oscarGanado = oscarGanado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public boolean isOscarGanado() {
        return oscarGanado;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos;
    }
}
