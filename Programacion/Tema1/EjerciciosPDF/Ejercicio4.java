package Programacion.Tema1.EjerciciosPDF;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Ejercicio4 {
    //Escribir un programa que convierta un valor dado en grados Fahrenheit a grados Celsius.
    //fórmula de conversión es= C=(F-32)*5/9
    public static void main(String[] args) {
        double far;
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba la temperatura en Fahrenheit: ");
        far = sc.nextDouble();
        System.out.println("Pasado a Celsius da como resultado: "+((far-32)*5/9));
    }
}
