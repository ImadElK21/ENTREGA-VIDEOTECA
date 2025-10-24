package modelo;

public class Videoteca {
    private Pelicula[] peliculas;
    private int numPeliculas;
    private double velocidadReproduccion;

    public Videoteca(int capacidad) {
        peliculas = new Pelicula[capacidad];
        numPeliculas = 0;
        velocidadReproduccion = 1.0;
    }

    public void setVelocidadReproduccion(double velocidad) {
        this.velocidadReproduccion = velocidad;
    }

    public boolean agregarPelicula(Pelicula p) {
        if (numPeliculas < peliculas.length) {
            peliculas[numPeliculas++] = p;
            return true;
        }
        return false;
    }

    public void mostrarPeliculas() {
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("| PELÍCULAS EN LA VIDEOTECA                                                                                                    |");
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------|");
        System.out.printf("| %-20s | %-11s | %-20s | %-13s | %-14s | %-24s | %-11s |%n",
                "Título", "Año Estreno", "Director", "Oscar ganado", "Duración (min)", "Tiempo visionado (min)", "Valoración");
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------|");

        double totalTiempo = 0;
        double totalValoracion = 0;

        for (int i = 0; i < numPeliculas; i++) {
            Pelicula p = peliculas[i];
            double tiempo = p.getTiempoVisionado(velocidadReproduccion);
            totalTiempo += tiempo;
            totalValoracion += p.getValoracion();

            System.out.printf("| %-20s | %-11d | %-20s | %-13s | %-14d | %-24.2f | %-11.2f |%n",
                    p.getTitulo(), p.getAnioEstreno(), p.getDirector().toString(),
                    p.getOscarTexto(), p.getDuracion(), tiempo, p.getValoracion());
        }

        if (numPeliculas > 0) {
            double promedio = totalValoracion / numPeliculas;
            System.out.println("|------------------------------------------------------------------------------------------------------------------------------|");
            System.out.printf("| Tiempo total de visionado: %.2f min | Valoración media: %.2f%n", totalTiempo, promedio);
        } else {
            System.out.println("| No hay películas en la videoteca. |");
        }

        System.out.println("|------------------------------------------------------------------------------------------------------------------------------|");
    }
}
