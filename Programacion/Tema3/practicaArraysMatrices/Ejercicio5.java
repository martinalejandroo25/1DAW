package Programacion.Tema3.practicaArraysMatrices;

import java.util.Scanner;

public class Ejercicio5 {
    /*Leer 10 números enteros y a continuación mostrar la media de los números introducidos, el mayor valor y el
menor valor. Usar un array para almacenar los valores y sacar toda la información en una sola iteración del array.
Si puedes mejóralo implementando una función para cada tarea (media, mayor, menor), pasando el array.*/
    public static void main(String[] args) {
        int[] numeros = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("Media de numeros");
        for (int i = 0; i < 10; i++) {
            System.out.println("Dame el numero " + (i+1));
            numeros[i] = Integer.parseInt(sc.nextLine());
        }
        int[] resultado = {mediaArray(numeros), superior(numeros), inferior(numeros)};
        System.out.println("La media es de "+resultado[0]);
        System.out.println("El mayor numero es el "+resultado[1]);
        System.out.println("El menor numero es el "+resultado[2]);

    }
    public static int mediaArray(int[] array) {
        int suma=0, media=0;
        for (int i = 0; i < array.length; i++) {
            suma += array[i];
        }
        media = suma/array.length;
        return media;
    }
    public static int superior(int[] array) {
        int superior=0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]>superior) {
                superior=array[i];
            }
        }
        return superior;
    }
    public static int inferior(int[] array) {
        int inferior=100000;
        for (int i = 0; i < array.length; i++) {
            if(array[i]<inferior) {
                inferior=array[i];
            }
        }
        return inferior;
    }
}
