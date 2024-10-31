package Programacion.Tema2.bucles.EjerciciosPDF;

import java.util.Scanner;

public class Ejercicio11 {
    // Programa (utilizando bucles) que muestre por pantalla la siguiente figura. Debe funcionar para n = número de líneas, que se pida por teclado.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el numero de filas de la piramide");
        int filas = Integer.parseInt(sc.nextLine());
        String ast = "*";
        String esp = " ";
        for (int i = filas; i > 0; i++) {
            System.out.print(esp);
            
            System.out.print(ast);
            ast += "*";
            System.out.println();
        }
    }
}
