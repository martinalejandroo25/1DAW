package Programacion.Tema1.EjerciciosPDF;

import java.util.Scanner;

public class Ejercicio6 {
    /*Realiza un programa que reciba una cantidad de minutos y muestre por pantalla a cuantas horas y minutos corresponde*/
    public static void main(String[] args) {
        int minutos;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero de minutos: ");
        minutos = sc.nextInt();
        System.out.println(minutos+" minutos es igual a "+ (minutos/60)+" horas y " +(minutos%60)+"minutos");
    }
}
