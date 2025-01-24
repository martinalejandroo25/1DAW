package Programacion.Tema3.practicaArraysMatrices;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio7 {
    /*Crear un programa que lea por teclado una tabla de 5 números enteros y la desplace una posición hacia la
derecha: el primero pasa a ser el segundo, el segundo pasa a ser el tercero y así sucesivamente. Igual que el
anterior, pero desplazando N posiciones (N es un número introducido por el usuario).*/

    public static void main(String[] args) {
        int n;
        int[] tabla = {1, 2, 3, 4, 5};// new int[5];
        Scanner sc = new Scanner(System.in);

//        for (int i = 0; i < 5; i++) {
//            System.out.println("Ingrese un numero (posición"+(i+1)+")");
//            tabla[i] = Integer.parseInt(sc.nextLine());
//        }
        System.out.println("Su tabla es la siguiente:");
        System.out.println(Arrays.toString(tabla));
        System.out.println("Cuantas posiciones quieres mover los numeros de la tabla?");
        n = Integer.parseInt(sc.nextLine());

        rotarArray(tabla, n);
        System.out.println("La nueva tabla se ha creado:");
        System.out.println(Arrays.toString(tabla));
    }

    public static void rotarArray(int[] array, int n) {
        n = n % array.length;

        if (n == 0) {
            return;
        }

        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[i] = array[i + n];
        }
        for (int i = 0; i < array.length - n; i++) {
            array[i] = array[i + n];
        }
        for (int i = 0; i < n; i++) {
            array[array.length - n + i] = temp[i];
        }
    }
}
