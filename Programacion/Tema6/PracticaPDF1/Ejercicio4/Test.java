package Programacion.Tema6.PracticaPDF1.Ejercicio4;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Test {
    public static void main(String[] args) {
        // Probar cuenta atrás
        System.out.println("📌 Probando cuenta atrás:");
        LocalDateTime fechaFutura = LocalDateTime.of(2030, 12, 31, 23, 59, 59);
        FechaUtils.cuentaAtras(fechaFutura, "Fin del año 2030");
        System.out.println();

        // Probar día de cumpleaños
        System.out.println("📌 Probando día de cumpleaños:");
        LocalDate fechaCumple = LocalDate.of(2000, 7, 14);
        int yearConsulta = 2025;
        String diaCumple = FechaUtils.diaCumple(fechaCumple, yearConsulta);
        System.out.println("El cumpleaños en el año " + yearConsulta + " cae en: " + diaCumple);
        System.out.println();

        // Probar número de años hasta una fecha
        System.out.println("📌 Probando cálculo de años hasta una fecha:");
        LocalDate fechaFutura2 = LocalDate.now().plusYears(5);
        int numYears = FechaUtils.numYears(fechaFutura2);
        System.out.println("Faltan " + numYears + " años hasta la fecha " + fechaFutura2);
        System.out.println();

        // Probar signo zodiacal
        System.out.println("📌 Probando signo zodiacal:");
        LocalDate fechaZodiaco = LocalDate.of(1995, 3, 21); // Aries
        String signo = FechaUtils.zodiaco(fechaZodiaco);
        System.out.println("La fecha " + fechaZodiaco + " corresponde al signo: " + signo);
        System.out.println();

        // Probar si una fecha está en un intervalo
        System.out.println("📌 Probando si una fecha está dentro de un intervalo:");
        LocalDateTime inicio = LocalDateTime.of(2022, 1, 1, 0, 0);
        LocalDateTime fin = LocalDateTime.of(2023, 1, 1, 0, 0);
        LocalDateTime dentro = LocalDateTime.of(2022, 6, 15, 12, 0);
        LocalDateTime fuera = LocalDateTime.of(2023, 6, 15, 12, 0);
        System.out.println("Fecha " + dentro + " está en el intervalo: " + FechaUtils.isIntervalo(inicio, fin, dentro));
        System.out.println("Fecha " + fuera + " está en el intervalo: " + FechaUtils.isIntervalo(inicio, fin, fuera));
        System.out.println();

        // Probar generación de fecha aleatoria
        System.out.println("📌 Probando generación de fecha aleatoria:");
        LocalDateTime fechaAleatoria = FechaUtils.fechaAzar(inicio, fin);
        System.out.println("Fecha aleatoria generada entre " + inicio + " y " + fin + ": " + fechaAleatoria);
    }
}
