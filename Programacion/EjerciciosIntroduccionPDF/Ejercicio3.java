package Programacion.Tema1.EjerciciosPDF;

import java.util.Scanner;

public class Ejercicio3 {
    //Dados dos numeros, mostrar la suma, resta, division, y multiplicacion de ambos

    public static void main(String[] args) {
        int num1;
        int num2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el primer numero");
        num1 = sc.nextInt();
        System.out.println("Ingrese el segundo numero");
        num2 = sc.nextInt();
        System.out.println("Suma: "+(num1+num2));
        System.out.println("Resta: "+(num1-num2));
        System.out.println("Multiplicacion: "+(num1*num2));
       if (num1 == 0 || num2 == 0) {
           System.out.println("No es posible realizar la division");
       } else {
           System.out.println("Division: "+(num1/num2));
       }
    }
}
