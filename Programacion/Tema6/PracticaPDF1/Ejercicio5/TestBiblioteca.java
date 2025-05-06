package Programacion.Tema6.PracticaPDF1.Ejercicio5;


import javax.swing.border.LineBorder;
import java.lang.runtime.SwitchBootstraps;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TestBiblioteca {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Publicacion> publicaciones = new ArrayList<>();
        String direccion = "calle ramon y cajala";
        Biblioteca biblioteca = new Biblioteca(publicaciones, direccion);

                //Creacion rapida de los libros y revistas con chatGPT
                // Crear 10 libros
        for (int i = 1; i <= 10; i++) {
            String isbnLibro   = String.format("978-84-%04d", i);
            String tituloLibro = "Libro " + i;
            int anioLibro      = 2000 + i;           // por ejemplo, años 2001, 2002, …
            int paginasLibro   = 100 + i * 10;       // por ejemplo, 110, 120, …
            boolean prestado   = (i % 2 == 0);       // prestado en los pares

            biblioteca.adquirirMaterial(new Libro(
                isbnLibro,
                tituloLibro,
                anioLibro,
                paginasLibro,
                prestado
            ));
        }

        // Crear 5 revistas
        for (int i = 1; i <= 5; i++) {
            String isbnRevista   = String.format("REV-%03d", i);
            String tituloRevista = "Revista " + i;
            int anioRevista      = 2021;             // todas del mismo año
            int paginasRevista   = 30 + i * 5;       // por ejemplo, 35, 40, …
            // número de ejemplar

            biblioteca.adquirirMaterial(new Revista(
                isbnRevista,
                tituloRevista,
                anioRevista,
                paginasRevista,
                    i
            ));
        }

        int opcion = 0;
        while (opcion != 4){
            System.out.println("""
                MENU DE LA BIBLIOTECA;
                    1.Prestar Publicacion
                    2.Devolver Publicacion
                    3.Busqueda
                    4.Salir
                """);
        opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1:
                    List<Libro> Libros = biblioteca.biblioteca.stream()
                            .filter(Libro.class::isInstance)
                            .map(Libro.class::cast)
                            .toList();

                    System.out.println("Titulo del libro a prestar");
                    String Titulo = sc.nextLine();
                    biblioteca.buscar(Titulo);
                    break;
                case 2:
                    System.out.println("Libros para Devolver:");
                    List<Libro> librosPrestados = biblioteca.biblioteca.stream()
                            .filter(Libro.class::isInstance)
                            .map(Libro.class::cast)
                            .filter(Libro::estaPrestado)
                            .toList();
                    System.out.println("Cual libro devuelve?");
                    String titulo = sc.nextLine();
                    for (Publicacion pub : biblioteca.biblioteca){
                        if (pub instanceof Libro libro){
                            if (libro.getTitulo().equalsIgnoreCase(titulo) && libro.estaPrestado()){
                                libro.devuelve();
                                System.out.println("Esta devuelto? : " + libro.estaPrestado());
                            }
                        }
                    }
            }
        }
    }
}
