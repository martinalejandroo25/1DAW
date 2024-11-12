package Programacion.Tema2.bucles.EjerciciosPDF;

import java.util.Scanner;

public class Ejercicio17 {
    /* Programa que lea un entero positivo introducido por el usuario y que muestre por pantalla todos sus divisores.*/
    public static void main(String[] args) {
        int num = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero para comprobar sus divisores: ");
        num = Integer.parseInt(sc.nextLine());
        for (int i = num; i > 0; i--) {
            if ((num % i) == 0){
                System.out.println(i+" Es divisible entre "+num);
            }

        }
    }
}
