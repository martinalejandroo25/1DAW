package Programacion.Tema3.practicaArraysMatrices;

public class Ejercicio1 {
    public static void main(String[] args) {
        /*Programa Java que guarda en un array 20 números enteros que se generen aleatoriamente entre -100 y 100. A
continuación, se recorre el array y calcula cuántos números son positivos y cuántos negativos.*/
        int numeros[] = new int[20];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = generarnumAleatorio(-100, 100);
        }
        pintarArray(numeros);
    }

    //FUNCIONES
    public static void pintarArray(int[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("["+numeros[i]+"], ");
        }
    }

    public static int generarnumAleatorio(int menor, int mayor) {
        return (int) (Math.random() * (mayor - menor + 1) + menor);

    }
}
