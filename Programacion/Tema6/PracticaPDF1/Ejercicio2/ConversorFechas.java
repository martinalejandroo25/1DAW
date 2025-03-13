package Programacion.Tema6.PracticaPDF1.Ejercicio2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConversorFechas {

// Realiza una clase ConversorFechas que tenga los siguientes métodos:
// String normalToAmericano(String). Este metodo convierte una fecha en formato normal dd/mm/yyyy a formato americano mm/dd/yyyy.
    public String normalToAmericano(String fechaNormal) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(fechaNormal, formatter);
        return date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    }
// String americanoToNormal(String). Este metodo realiza el paso contrario, convierte fechas en formato americano a formato normal.
    public String americanoToNormal(String fechaAmericano) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(fechaAmericano, formatter);
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
