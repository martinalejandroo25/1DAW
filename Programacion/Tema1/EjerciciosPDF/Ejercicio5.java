package Programacion.Tema1.EjerciciosPDF;

import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num1, num2, num3;
        System.out.print("introduce el primer numero: ");
        num1 = sc.nextDouble();
        System.out.println("introduce el segundo numero ");
        num2 = sc.nextDouble();
        System.out.println("introduce el tercer numero: ");
        num3 = sc.nextDouble();

        System.out.println("La media da como resultado: "+ ((num1+num2+num3)/3));
    }
}
