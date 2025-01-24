package Programacion.Tema3.practicaArraysMatrices;
import java.util.Arrays;


public class Ejercicio10 {
    /*Realiza una función que devuelva un array con una combinación de la Lotería Primitiva (6 números entre 1 y 49).
La particularidad es que los números no deben estar repetidos.*/
    public static void main(String[] args) {
        int[] loteria = new int[6];
        for (int i = 0; i < loteria.length; i++) {
            int numero = generarnumAleatorio(1,49);
            int comprobar = indexOf(loteria, numero);

            if (comprobar == -1){
                loteria[i] = numero;
            }
        }
        System.out.println("Numero de loteria generado:");
        System.out.println(Arrays.toString(loteria));
    }
    public static int generarnumAleatorio(int menor, int mayor) {
        return (int) (Math.random() * (mayor - menor + 1) + menor);

    }
    public static int indexOf(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1; // retorna -1 si no se encuentra
    }

}
