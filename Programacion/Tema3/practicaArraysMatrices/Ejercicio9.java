package Programacion.Tema3.practicaArraysMatrices;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio9 {
    /*Realizar un programa que lea los tiempos en los que 10 corredores han acabado una carrera.
      El programa debe determinar qué corredores tienen el primer, segundo y último puesto,
      así como cuál es el tiempo medio en que se ha corrido la carrera. Pista: ordénalo antes.*/

    public static void main(String[] args) {
        double[] tiempos = new double[10];
        Scanner sc = new Scanner(System.in);

        // Leer tiempos
        for (int i = 0; i < 10; i++) {
            System.out.println("¿Cuál es el tiempo del corredor " + (i + 1) + "?");
            tiempos[i] = Double.parseDouble(sc.nextLine());
        }

        // Mostrar tiempos originales
        System.out.println("Tiempos originales: " + Arrays.toString(tiempos));

        // Obtener puestos
        mostrarPuestosYMedia(tiempos);
    }

    public static void mostrarPuestosYMedia(double[] tiempos) {
        // Crear copia y ordenar
        double[] tiemposOrdenados = Arrays.copyOf(tiempos, tiempos.length);
        Arrays.sort(tiemposOrdenados);

        // Tiempo medio
        double suma = 0;
        for (double t : tiempos) {
            suma += t;
        }
        double media = suma / tiempos.length;

        // Determinar posiciones (primer, segundo y último)
        double primero = tiemposOrdenados[0];
        double segundo = tiemposOrdenados[1];
        double ultimo = tiemposOrdenados[tiemposOrdenados.length - 1];

        int indexPrimero = indexOf(tiempos, primero);
        int indexSegundo = indexOf(tiempos, segundo);
        int indexUltimo = indexOf(tiempos, ultimo);

        System.out.println("Primer puesto: Corredor " + (indexPrimero + 1) + " con tiempo " + primero);
        System.out.println("Segundo puesto: Corredor " + (indexSegundo + 1) + " con tiempo " + segundo);
        System.out.println("Último puesto: Corredor " + (indexUltimo + 1) + " con tiempo " + ultimo);
        System.out.println("Tiempo medio de la carrera: " + media);
    }

    // Método auxiliar para encontrar el índice de un valor en un array
    private static int indexOf(double[] array, double value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1; // no debería ocurrir si el valor está garantizado
    }
}
