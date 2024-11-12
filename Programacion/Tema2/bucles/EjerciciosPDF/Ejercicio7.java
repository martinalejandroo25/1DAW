package Programacion.Tema2.bucles.EjerciciosPDF;

import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        // Función que calcule el factorial de un número entero positivo pasado como parámetro. factorial = num x (n - 1) x (n - 2) x... x 1
        Scanner sc = new Scanner(System.in);
        System.out.println("A que número entero quieres calcular su factorial?");
        int num = Integer.parseInt(sc.nextLine());
        System.out.println(factorial(num));

    }
    public static int factorial(int num){
        int resultado = 1;
        for (int i = 1; i <= num ; i++) {

            resultado *= i ;
        }
        return resultado;
    }
}
