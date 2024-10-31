package Programacion.Tema2.bucles.EjerciciosPDF;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        // Programa que pida al usuario un número repetidamente hasta que esté entre 1 y 10.
        System.out.println("Dame un número del 1 al 10");
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        while (!EsDel1al10(num)) {
            System.out.println("El numero no es correcto, dame un número del 1 al 10");
            num = Integer.parseInt(sc.nextLine());
        }
        System.out.println("Bien! el "+num+" esta dentro del rango 1 al 10");
    }
    public static boolean EsDel1al10(int num) {
        return num >= 1 && num <= 10;
    }
}
