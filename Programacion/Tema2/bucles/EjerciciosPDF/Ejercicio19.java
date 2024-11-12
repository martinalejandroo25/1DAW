package Programacion.Tema2.bucles.EjerciciosPDF;

import java.util.Scanner;

public class Ejercicio19 {
    /*Diseña un metodo que indique si un número entero pasado como parámetro es o no un número primo
(devuelve un boolean). Un número primo es aquel que tiene por divisores el 1 y el propio número,
únicamente.*/
    public static void main(String[] args) {
        double num;
        boolean esPrimo;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero a comprobar si es primo");
        num = Double.parseDouble(sc.nextLine());
        esPrimo = esPrimos(num);
        if (esPrimo)
            System.out.println("El número es primo");
        else
            System.out.println("El número NO es primo");

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
