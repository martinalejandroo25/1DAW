package Programacion.Tema6.PracticaPDF1.Ejercicio4;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class FechaUtils {

    public static void cuentaAtras(LocalDateTime fechaHasta, String titulo){
        int z = fechaHasta.getYear();
        int x = fechaHasta.getMonthValue();
        int d = fechaHasta.getDayOfMonth();
        int h = fechaHasta.getHour();
        int m = fechaHasta.getMinute();
        int s = fechaHasta.getSecond();
        System.out.println("Faltan " +
                z + " años, " +
                x + " meses, " +
                d + " días, " +
                h + " horas, " +
                m + " minutos, " +
                s + " segundos para: " + titulo);
    }

    public static String diaCumple(LocalDate fechaCumple, int year){
        Locale locale = new Locale("es", "ES");
        LocalDate cumple = LocalDate.of(year, fechaCumple.getMonthValue(), fechaCumple.getDayOfMonth());
        return cumple.getDayOfWeek().getDisplayName(java.time.format.TextStyle.FULL, locale);
    }
    public static int numYears(LocalDate fechaCumple){
        LocalDate hoy = LocalDate.now();
        return (int)hoy.until(fechaCumple, ChronoUnit.YEARS);
    }
    public static String zodiaco(LocalDate fecha) {
        enum Signo {ARIES, TAURUS, GEMINIS, CANCER, LEO, VIRGO, LIBRA, ESCORPION, SAGITARIO, CAPRICORNIO, ACUARIO, PISCIS};
        return Signo.values()[(fecha.getMonthValue() - 1)].toString();
    }
    //devuelve true si fecha está entre inicio y fin
    public static boolean isIntervalo(LocalDateTime inicio, LocalDateTime fin, LocalDateTime fecha) {
        return fecha.isAfter(inicio) && fecha.isBefore(fin);
    }
    public static LocalDateTime fechaAzar(LocalDateTime inicial, LocalDateTime fin) {
        long diasAzar = 0;
        if (inicial.isAfter(fin)) {
            System.out.println("la fechan inicial no puede ser posterior a la fecha final");
        } else {
            long diasEntre = ChronoUnit.DAYS.between(inicial, fin);
            diasAzar = (long) (Math.random() * diasEntre) + 1;
        }
        return inicial.plusDays(diasAzar);

    }
}
