package Programacion.Tema7.Practica2Streams.SensoresPlantacion;

import Programacion.ProgramacionFuncionalOpenWebinars.Product;
import Programacion.Streamsopenwebinars.StreamEmpty;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Registro> registros = generateRegistros();
        System.out.println(registros);

        System.out.println("1. Filtrar los registros de temperatura que sean mayores a 25 grados, la humedad sea menor a 70 y la\n" +
                "fecha sea anterior a la fecha actual, y mostrarlos.");
        registros.stream()
                .filter(r -> r.getTemperatura() > 25 && r.getHumedad() < 70)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("2. Encontrar el registro con la temperatura más alta y mostrar el registro completo.");
        Optional<Registro> tempMax = registros.stream()
                .max(Comparator.comparingDouble(Registro::getTemperatura));
        tempMax.ifPresent(System.out::println);


        System.out.println();
        System.out.println("3. Obtener una lista con las fechas/horas de todas las tomas de datos.");
        registros.stream()
                .map(Registro::getFechaHora)
                .forEach(System.out::println);
        System.out.println();
        System.out.println("4. Incrementar en 5 unidades la humedad de todos los registros y mostrar las temperaturas,\n" +
                "humedades y fechas/horas actualizadas.");
        registros.stream()
                .map(r -> "Temperatura: " + r.getTemperatura() +
                                    " Humedad: " + (r.getHumedad() + 5) +
                                    " Fecha y Hora: " + r.getFechaHora())
                .forEach(System.out::println);

        System.out.println();
        System.out.println("5. Encontrar el registro con la temperatura más baja que tenga una humedad mayor a 80 y mostrar la\n" +
                "temperatura, humedad y fecha.");

        registros.stream()
                .filter(registro -> registro.getHumedad() > 80)
                .min(Comparator.comparing(Registro::getTemperatura))
                .ifPresent(System.out::println);

        System.out.println();
        System.out.println("6. Verificar si algún registro tiene una temperatura mayor a 30 grados, humedad mayor a 90 y la fecha\n" +
                "es de hoy. Mostrar un mensaje indicando si hay algún registro que cumple esta condición o no.");
        boolean existeRegistro = registros.stream()
                .anyMatch( r ->
                        r.getTemperatura() > 30 &&
                        r.getHumedad()     > 90 &&
                        Objects.equals(r.getFechaHora().toLocalDate(), LocalDate.now())
                );
        System.out.println(
                existeRegistro ? "Se ha encontrado uno o mas registros coincidentes"
                        : "No se ha encontrado ningun registro coincidente"
        );

        System.out.println();
        System.out.println("7. Muestra 10 registros saltandote los 5 primeros");
        registros.stream()
                .skip(5)
                .limit(10)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("9. Muestra los registros ordenados pro fecha (sorted(Comparator)");
        registros.stream()
                .sorted(Comparator.comparing(Registro::getFechaHora))
                .forEach(System.out::println);

        System.out.println();
        System.out.println("10. Calcular la temperatura promedio de todos los registros (transformarlo en Stream<Double> y\n" +
                "llamar a average()).");
        Stream<Double>tempPromedio = Stream.of(registros.stream()
                .collect(Collectors.summarizingDouble(Registro::getTemperatura))
                .getAverage());
        tempPromedio.forEach(System.out::println);

    }

    private static List<Registro> generateRegistros() {
        List<Registro> registros = new ArrayList<>();
        LocalDate fecha = LocalDate.now();
        int hora = 12;
        int minuto = 0;

        for (int i = 0; i < 100; i++) {
            // Construyo el timestamp
            LocalDateTime ts = LocalDateTime.of(fecha, LocalTime.of(hora, minuto));

            // Genero dos valores aleatorios, por ejemplo entre 45–46 y 0–100
            double valor1 = Math.random() * (45 + 1);           // [45.0,46.0)
            double valor2 = Math.random() * 101;          // [0.0,101.0)

            registros.add(new Registro(ts, valor1, valor2));

            // Incremento minuto y ajusto hora
            minuto++;
            if (minuto == 60) {
                minuto = 0;
                hora++;
                if (hora == 24) {
                    hora = 0;
                    fecha = fecha.plusDays(1);  // Si quisieras pasar al día siguiente
                }
            }
        }

        return registros;
    }

}

