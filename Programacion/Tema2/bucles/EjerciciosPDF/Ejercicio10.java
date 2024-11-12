package Programacion.Tema2.bucles.EjerciciosPDF;

import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        // Programa (utilizando bucles) que muestre por pantalla la siguiente figura. Debe funcionar para n = número de líneas, que se pida por teclado.
        Scanner sc = new Scanner(System.in);
        System.out.println("De cuantas filas va a ser la piramide?");
        int filas = Integer.parseInt(sc.nextLine());
        String ast = "*";
        for (int i = 0; i < filas; i++) {
            System.out.print(ast);
            ast += "*";
            System.out.println();
        }
    }
}
