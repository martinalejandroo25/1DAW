package Programacion.Tema3.Array;

import java.util.Scanner;

public class EjercicioClase3 {
    public static void main(String[] args) {
        //Genera un array de 20 numeros enteros aleatorios (entre 1 y 1000)
        //Muestra sólo aquellos que sean primos

        int numeros[] = new int[20];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = generarnumAleatorio(1, 1000);
            if (esPrimos(numeros[i])) {

                System.out.println("[" + numeros[i] + "] ");
            }
        }

    }
    public static int generarnumAleatorio(int menor, int mayor) {
        return (int) (Math.random() * (mayor - menor + 1) + menor);

    }

    public static boolean esPrimos(int num){
        boolean esPrimo = true;
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                esPrimo = false;
                break;
            }
        }
        return esPrimo;
    }

}


