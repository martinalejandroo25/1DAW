package Programacion.Tema7.EjerciciosStreams.Canciones;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {
        List<Cancion> canciones = new ArrayList<>(List.of(
                new Cancion("Blinding Lights", new Artista("The Weeknd", "Canadá"), 2024, 200, 90.5, Genero.POP),
                new Cancion("Levitating", new Artista("Dua Lipa", "Reino Unido"), 2024, 203, 88.7, Genero.POP),
                new Cancion("Lost Souls", new Artista("Foo Fighters", "EE. UU."), 2024, 210, 91.0, Genero.ROCK),
                new Cancion("Rise Again", new Artista("Sam Smith", "Reino Unido"), 2025, 220, 92.5, Genero.POP),
                new Cancion("Phoenix Rising", new Artista("Paramore", "EE. UU."), 2025, 180, 89.7, Genero.ROCK),
                new Cancion("The Final Frontier", new Artista("Ghost", "Suecia"), 2025, 215, 92.1, Genero.METAL),
                new Cancion("Shining Star", new Artista("Doja Cat", "EE. UU."), 2025, 185, 88.7, Genero.HIPHOP),
                new Cancion("Crimson Skies", new Artista("Foo Fighters", "EE. UU."), 2025, 225, 93.3, Genero.ROCK),
                new Cancion("Kiss Me More", new Artista("Doja Cat", "EE. UU."), 2024, 205, 87.1, Genero.POP)
        ));

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
        System.out.println();
        System.out.println("6. Muestra las canciones agrupadas por genero, cuantas por cada uno");
        List<Cancion> cancionList = canciones.stream().toList();
        Map<Genero, Long> cancionesPorGenero = cancionList.stream()
                .collect(
                        groupingBy(Cancion::getGenero, //clave: el enum Genero
                                counting() // downstream: contar elementos
                ));
        cancionesPorGenero.forEach((genero, count)
                -> System.out.println(genero + " " + count));

        System.out.println();
        System.out.println("7. Comprueba si hay alguna canción con más del 95% de popularidad, y 90%");
        canciones.stream()
                .filter(cancion -> cancion.getPopularidad() > 90)
                .peek(cancion -> System.out.println("mayor al 90% -> " + cancion))
                .filter(cancion -> cancion.getPopularidad() > 95)
                .peek(cancion -> System.out.println("mayor al 95% -> " + cancion))
                .forEach(System.out::println);
        System.out.println();
        System.out.println("8. Muestra las tres canciones de más duración");
        Comparator<Cancion> cancionComparator = Comparator.comparing(Cancion::getDuracionSegs);
        Collections.sort(canciones, cancionComparator.reversed());
        canciones.stream()
                .limit(3)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("9. Genera una lista: titulo – artista, de todas las canciones ordenada alfabéticamente.");

        List<String> CancionArtista = canciones.stream()
                // Convertimos cada cancion en un String "título - artista"
                .map(c -> c.getTitulo() + " - " + c.getArtista().getNombre())
                // Ordenamos esas cadenas alfabeticamente
                .sorted()
                // Recogemos el resultado en una List<String>
                .collect(toList());

        CancionArtista.forEach(System.out::println);

        System.out.println();
        System.out.println("10. Muestra la duración media de las canciones");
        canciones.stream()
                .mapToDouble(Cancion::getDuracionSegs)
                .average()
                .ifPresent(System.out::println);

        System.out.println();
        System.out.println("11. Muestra las estadísticas de popularidad (summarizingDouble)");
        DoubleSummaryStatistics stats = canciones.stream()
                .collect(summarizingDouble(Cancion::getPopularidad));
        System.out.println(stats.getCount());
        System.out.println(stats.getMin());
        System.out.println(stats.getMax());
        System.out.println(stats.getAverage());
        System.out.println(stats.getSum());
    }
}
