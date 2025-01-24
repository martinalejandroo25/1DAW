package Programacion.Tema3.practicaArraysMatrices;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio3 {
    /*Crea un array de números de un tamaño pasado por teclado, el array contendrá números aleatorios entre 1 y 300
y mostrar aquellos números que acaben en un dígito que nosotros le indiquemos por teclado (debes controlar
que se introduce un numero correcto), estos deben guardarse en un nuevo array. Por ejemplo, en un array de 10
posiciones e indicamos mostrar los números acabados en 5, podría salir 155, 25, etc. Cuando llene el segundo
array finalizamos.*/
    public static void main(String[] args) {
        int arraySize = 0;
        int conta=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("De que tamaño será el Array?");
        arraySize = Integer.parseInt(sc.nextLine());
        int[] numeros = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            numeros[i] = generarnumAleatorio(1,300);
            if (Integer.toString(numeros[i]).endsWith("5")){
                conta++;
            }
        }
        int[] cincos = new int[conta];
        for (int i = 0; i < conta; i++) {
            if (Integer.toString(numeros[i]).endsWith("5")){
                cincos[i] = numeros[i]; //aqui está el problema
            }
        }
        System.out.println(Arrays.toString(cincos));
    }
    public static int generarnumAleatorio(int menor, int mayor) {
        return (int) (Math.random() * (mayor - menor + 1) + menor);

    }
}
