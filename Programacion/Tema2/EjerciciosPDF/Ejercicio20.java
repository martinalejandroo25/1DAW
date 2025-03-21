package Programacion.Tema2.bucles.EjerciciosPDF;

import java.util.Scanner;

public class Ejercicio20 {
    /* Programa que, dado un número entero positivo introducido por teclado, visualice por pantalla todos los
números primos menores que él. Utiliza la función del ejercicio anterior.*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        boolean esPrimo;
        System.out.println("Ingrese un número:");
        num = Integer.parseInt(sc.nextLine());
        System.out.println("Los primos menores de "+num+" son");
        for (int i = num; i > 0; i--) {
            if (esPrimos(i))
                System.out.print(i+", ");
        }
    }
    public static boolean esPrimos(double num){
        boolean esPrimo = true;
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                esPrimo = false;
                break;
            }
        }
        return esPrimo;
    }
}
