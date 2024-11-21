package Programacion.Tema3.Array.EjerciciosArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        /*2. Programa que declare tres vectores de enteros, 10 elementos cada uno, pida por teclado los valores de vector1 y vector2 y calcule vector3 como la suma de los anteriores y lo pinte por pantalla.*/

        int array1[] = new int[10];
        int array2[] = new int[10];
        int array3[] = new int[10];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.println(" primer Array, Dame un número "+i+"/"+array1.length);
            array1[i] = Integer.parseInt(sc.nextLine());
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(" Segundo Array, Dame un número "+i+"/"+array1.length);
            array2[i] = Integer.parseInt(sc.nextLine());
        }
        for (int i = 0; i < array3.length; i++) {
            array3[i] = array1[i] + array2[i];
        }
        System.out.println(Arrays.toString(array3));

    }
}
