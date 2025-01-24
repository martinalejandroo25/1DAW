package Programacion.Tema3.practicaArraysMatrices;

import java.util.Arrays;

/* Ordenar matrices. Crea una matriz de enteros de dos dimensiones de 50x50 elementos, rellénala con números
aleatorios entre 1 y 500. A continuación, realiza dos funciones:
a.
 ordenaFilas(matriz): que ordene la matriz por filas, cada fila de la matriz quedará ordenada de menor a
mayor.
b.
 ordenaColumnas(matriz): que ordene la matriz por columnas, cada columna quedará ordenada de
menor a mayor, independientemente de las demás.*/
public class Ejercicio17 {
    public static void main(String[] args) {

    }

    public void OrdenarFilas( int[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            Arrays.sort(matriz[i]);
        }

    }

    public static void ordenarColumnas(int matriz[][]) {
        for (int i = 0; i < matriz[0].length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                //intercambiar matriz[i][j] con el anterior
                if (matriz[i][j] > matriz[i][i]) {}
            }
        }

        //matriz[0][0], matriz [1][0], matriz[2][0] ...
    }
}
