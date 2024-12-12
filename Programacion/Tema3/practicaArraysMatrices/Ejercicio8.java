package Programacion.Tema3.practicaArraysMatrices;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio8 {
    /*Genera aleatoriamente una tabla de 10 elementos numéricos enteros, guardalos en una array. Luego pide por
teclado una posición (entre 0 y 9). Eliminar el elemento situado en la posición dada sin dejar huecos.*/
    public static void main(String[] args) {
        int[] tabla = new int[10];
        Scanner sc = new Scanner(System.in);
        int posicion;
        for (int i = 0; i < 10; i++) {
            tabla[i] = generarnumAleatorio(1,10);
        }
        System.out.println("Su tabla es la siguiente:");
        System.out.println(Arrays.toString(tabla));
        System.out.println("Elija la posicion del elemento que quiere eliminar del 0 al 9");
        posicion = Integer.parseInt(sc.nextLine());
        deletePosicionArray(tabla, posicion);
        System.out.println("Su tabla ahora es:");
        System.out.println(Arrays.toString(tabla));
    }

    //FUNCIONES
    public static int generarnumAleatorio(int menor, int mayor) {
        return (int) (Math.random() * (mayor - menor + 1) + menor);
    }
    public static void deletePosicionArray(int[] array, int posicion){
        if (posicion <= array.length - 1  && posicion >= 0){
            //Desplazar todos los elementos a la izquierda desde 'posicion'
            for (int i = posicion; i < array.length - 1; i++) {
             array[i] = array[i + 1];

            }
            //Colocar un valor neutral al final
            array[array.length - 1] = 0;


        }
    }
}
