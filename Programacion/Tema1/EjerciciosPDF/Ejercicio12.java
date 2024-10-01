package Programacion.Tema1.EjerciciosPDF;

public class Ejercicio12 {
    // Realiza un programa en Java que, dadas dos variable a y , intercambie los valores de a y b
    public static void main(String[] args) {
        int a = 4;
        int b = 6;
        int cambio = a;
        a = b;
        b= cambio;
        System.out.println(a);
        System.out.println(b);
    }
}
