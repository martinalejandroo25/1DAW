package Programacion.Tema2.bucles.EjerciciosPDF;

import java.util.Scanner;

public class Ejercicio2 {
    //Programa que lea un número por teclado e indique si es múltiplo de 2, 3, 5 o 7.

    public static boolean esmultiplo(int a, int b) {
        return a % b == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero: ");
        int numero = Integer.parseInt(sc.nextLine());
        System.out.println("Es multiplo de 2?: "+esmultiplo(numero, 2));
        System.out.println("Es multiplo de 3?: "+esmultiplo(numero, 3));
        System.out.println("Es multiplo de 5?: "+esmultiplo(numero, 5));
        System.out.println("Es multiplo de 7?: "+esmultiplo(numero, 7));
    }
}
