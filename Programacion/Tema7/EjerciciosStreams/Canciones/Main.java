package Programacion.Tema7.EjerciciosStreams.Canciones;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Main {
    public static void main(String[] args) {
        List<Cancion> canciones = List.of(
                new Cancion("Blinding Lights", new Artista("The Weeknd", "Canadá"), 2024, 200, 90.5, Genero.POP),
                new Cancion("Levitating", new Artista("Dua Lipa", "Reino Unido"), 2024, 203, 88.7, Genero.POP),
                new Cancion("Lost Souls", new Artista("Foo Fighters", "EE. UU."), 2024, 210, 91.0, Genero.ROCK),
                new Cancion("Rise Again", new Artista("Sam Smith", "Reino Unido"), 2025, 220, 92.5, Genero.POP),
                new Cancion("Phoenix Rising", new Artista("Paramore", "EE. UU."), 2025, 180, 89.7, Genero.ROCK),
                new Cancion("The Final Frontier", new Artista("Ghost", "Suecia"), 2025, 215, 92.1, Genero.METAL),
                new Cancion("Shining Star", new Artista("Doja Cat", "EE. UU."), 2025, 185, 88.7, Genero.HIPHOP),
                new Cancion("Crimson Skies", new Artista("Foo Fighters", "EE. UU."), 2025, 225, 93.3, Genero.ROCK),
                new Cancion("Kiss Me More", new Artista("Doja Cat", "EE. UU."), 2024, 205, 87.1, Genero.POP)
        );

        System.out.println("1. Muestra las canciones de 2025");
        canciones.stream()
                        .filter((p) -> p.getLanzamientoYear() == 2025)
                                .forEach(System.out::println);

        System.out.println();
        System.out.println("2. Muestra las canciones de Doja Cat");
        canciones.stream()
                .filter((p) -> p.getArtista().getNombre().equals("Doja Cat"))
                                        .forEach(System.out::println);

        System.out.println();
        System.out.println("3. Muestra las canciones ordenadas de mayor a menor por popularidad");
        canciones.stream()
                .sorted(Comparator.comparing(Cancion::getPopularidad))
                .toList().forEach(System.out::println);

        System.out.println();
        System.out.println("4. Calcula la duracion total de todas las canciones en minutos");
        int totalDuracion = canciones.stream()
                .mapToInt(Cancion::getDuracionSegs) //Convierte Stream<Cancion> a IntStream
                .sum();                             //Suma todos los valores
        System.out.println("Duracion total de " +(totalDuracion/60)+ " minutos");

        System.out.println();
        System.out.println("5. Agrupa las canciones por pais de origen y cuantas canciones por pais");
        System.out.println(
                // Mapa de pais -> numero de canciones
                canciones.stream()
                .collect(
                        groupingBy(
                                Cancion -> Cancion.getArtista().getPais(), //clave: pais del artista
                                counting()                                         //valor: contar cuantos hay
                        )
                ));
    }
}
