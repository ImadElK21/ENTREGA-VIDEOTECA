import modelo.*;
import esdia.EsDia;

public class App {
    public static void main(String[] args) {
        Videoteca videoteca = null;
        boolean salir = false;

        do {
            System.out.println("\n|----------------------------------------------|");
            System.out.println("| MI VIDEOTECA                                 |");
            System.out.println("|----------------------------------------------|");
            System.out.println("| 1) Nueva videoteca de películas              |");
            System.out.println("| 2) Configurar velocidad de reproducción      |");
            System.out.println("| 3) Añadir una nueva película a la videoteca  |");
            System.out.println("| 4) Mostrar información actual de películas   |");
            System.out.println("| 5) Salir                                     |");
            System.out.println("|----------------------------------------------|");

            int opcion = EsDia.readInt("Seleccione una opción (1-5): ", 1, 5);

            switch (opcion) {
                case 1:
                    int capacidad = EsDia.readInt("¿Cuántas películas desea almacenar?: ", 1, 100);
                    videoteca = new Videoteca(capacidad);
                    System.out.println("Nueva videoteca creada correctamente.");
                    break;

                case 2:
                    if (videoteca == null) {
                        System.out.println("Primero debe crear una videoteca.");
                    } else {
                        double vel = EsDia.readDouble("Introduzca la velocidad de reproducción (0.5 - 3.0): ", 0.5, 3.0);
                        videoteca.setVelocidadReproduccion(vel);
                        System.out.println("Velocidad configurada correctamente.");
                    }
                    break;

                case 3:
                    if (videoteca == null) {
                        System.out.println("Primero debe crear una videoteca.");
                    } else {
                        String titulo = EsDia.readString_ne("Título de la película: ");
                        int anio = EsDia.readInt("Año de estreno: ", 1900, 2025);
                        int duracion = EsDia.readInt("Duración (min): ", 1, 500);
                        double valoracion = EsDia.readDouble("Valoración (0.0 - 10.0): ", 0.0, 10.0);

                        String nombre = EsDia.readString_ne("Nombre del director: ");
                        String apellidos = EsDia.readString_ne("Apellidos del director: ");
                        boolean oscar = EsDia.yesOrNo("¿Ha ganado un Oscar? (y/n): ");

                        Director d = new Director(nombre, apellidos, oscar);
                        Pelicula p = new Pelicula(titulo, anio, duracion, valoracion, d);

                        if (videoteca.agregarPelicula(p)) {
                            System.out.println("Película añadida correctamente.");
                        } else {
                            System.out.println("La videoteca está llena.");
                        }
                    }
                    break;

                case 4:
                    if (videoteca == null) {
                        System.out.println("Primero debe crear una videoteca.");
                    } else {
                        videoteca.mostrarPeliculas();
                    }
                    break;

                case 5:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
            }

        } while (!salir);
    }
}
