package Programacion.Tema6.PracticaPDF1.Ejercicio2;


public class Test {
    public static void main(String[] args) {
        ConversorFechas conversor = new ConversorFechas();

        String fechaNormal = "15/12/2023";
        String fechaAmericano = conversor.normalToAmericano(fechaNormal);
        System.out.println("Fecha en formato americano: " + fechaAmericano);

        String fechaNormalConverted = conversor.americanoToNormal(fechaAmericano);
        System.out.println("Fecha en formato normal: " + fechaNormalConverted);
    }
}