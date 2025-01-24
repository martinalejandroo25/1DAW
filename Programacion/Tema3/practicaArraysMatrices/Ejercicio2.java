package Programacion.Tema3.practicaArraysMatrices;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2 {
/*Crea una función que reciba como parámetro un array de 10 enteros, debe devolver el mismo array donde se
hayan intercambiado el primer elemento y el último elemento.*/
public static void main(String[] args) {
    int numeros[] = {1,2,3,4,5,6,7,8,9};
    IntercambioPrimerUltimo(numeros);
    System.out.println(Arrays.toString(numeros));

}
public static int[] IntercambioPrimerUltimo(int[] numeros) {
     int cambio = numeros[0];
    numeros [0] = numeros[numeros.length-1];
    numeros[numeros.length-1] = cambio;
    return numeros;

}
}
