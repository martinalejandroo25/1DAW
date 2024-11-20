package Programacion.Tema3.Array.EjerciciosArrays;

import java.util.Scanner;

public class Ejercicio1 {
    /*1. Crea un programa que pida un número al usuario un número de mes (por ejemplo, el 4) y
diga cuántos días tiene (por ejemplo, 30) y el nombre del mes. Debes usar un vector. Para
simplificarlo vamos a suponer que febrero tiene 28 días.*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe un numero del mes, 1 al 12");
        int mes = Integer.parseInt(scanner.nextLine());
        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] nombreMes = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        System.out.println("Mes: " + nombreMes[mes - 1]);
        System.out.println("Dias: " + diasPorMes[mes - 1]);
    }
}
