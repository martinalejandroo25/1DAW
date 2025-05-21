package Programacion.Tema7.FicherosConJavaNIO2.Ejercicio1;

import Programacion.Streamsopenwebinars.StreamEmpty;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileUtils {
    public static long calcularTamanoDirectorio(Path dirPath){
        try (Stream<Path> stream = Files.walk(dirPath)) {
            return stream
                    .filter(Files::isRegularFile)
                    .mapToLong(path -> {
                        try {
                            return Files.size(path);
                        } catch (IOException e) {
                            throw new UncheckedIOException(e);
                        }
                    })
                    .sum();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        Path dir = Path.of("Programacion");
        long tamano = calcularTamanoDirectorio(dir);
        System.out.println("El directorio ocupa: " + tamano);
    }
}
