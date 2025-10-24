package modelo;

public class Pelicula {
    private String titulo;
    private int anioEstreno;
    private int duracion;
    private double valoracion;
    private Director director;

    public Pelicula(String titulo, int anioEstreno, int duracion, double valoracion, Director director) {
        this.titulo = titulo;
        this.anioEstreno = anioEstreno;
        this.duracion = duracion;
        this.valoracion = valoracion;
        this.director = director;
    }

    public String getTitulo() { return titulo; }
    public int getAnioEstreno() { return anioEstreno; }
    public int getDuracion() { return duracion; }
    public double getValoracion() { return valoracion; }
    public Director getDirector() { return director; }

    public String getOscarTexto() {
        return director.isOscarGanado() ? "Sí" : "No";
    }

    public double getTiempoVisionado(double velocidad) {
        return duracion / velocidad;
    }
}
