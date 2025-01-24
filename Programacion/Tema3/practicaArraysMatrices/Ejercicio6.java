package Programacion.Tema3.practicaArraysMatrices;

import java.util.Arrays;

public class Ejercicio6 {
    /*Generar 10 números enteros aleatorios. Debemos mostrarlos en el siguiente orden: el primero, el último, el
segundo, el penúltimo, el tercero, etc... Pista: primero los guardas en un array y luego lo recorres como indica.*/
    public static void main(String[] args) {
        int[] numeros = new int[10];
        for (int i = 0; i < 10; i++) {
            numeros[i]  = generarnumAleatorio(1, 100);
        }
        System.out.println(Arrays.toString(numeros));
        imprimirArray(numeros);

    }

    //FUNCIONES
    public static int generarnumAleatorio(int menor, int mayor) {
        return (int) (Math.random() * (mayor - menor + 1) + menor);

    }
    public static void imprimirArray(int[] array) {
         int inicio = 0;
         int fin = array.length -1;
        System.out.print("[");
         while (inicio <= fin) {

             System.out.print(array[inicio] + ", " + array[fin] + ", ");
             inicio++;
             fin--;
         }
        System.out.print("]");
        }
    }


