package Programacion.Examen1Evaluacion;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio1 {
    /*Nos piden crear una matriz 20×20 de números enteros que inicialmente
rellenamos de valores aleatorios (1-100)
nos piden hacer un menú con estas opciones:
1.2.3.4.5.6.Intercambiar columna. Te pedirá dos números de columna e intercambiará los
valores de la primera por los valores de la segunda.
Suma de una fila que se pedirá al usuario (controlar que elija una correcta)
Comprueba si la diagonal principal y la inversa son iguales.
Pintar las coordenadas i,j donde se encuentra el menor elemento de la matriz.
Muestra la matriz con las filas ordenadas de menor a mayor
Salir*/
    public static void main(String[] args) {
        int[][] matriz = new int[20][20];
        Scanner sc = new Scanner(System.in);
        int opcion;
        rellenarMatriz(matriz);
        System.out.println("La matriz generada es la siguiente:");
        pintarMatriz(matriz);

        //MENU

        System.out.println("Elije una de las siguientes opciones:");
        System.out.println("""
                1. Intercambiar columna. Te pedirá dos números de columna e intercambiará los
                   valores de la primera por los valores de la segunda.
                2.Suma de una fila que se pedirá al usuario
                3.Comprueba si la diagonal principal y la inversa son iguales.
                4.Pintar las coordenadas i,j donde se encuentra el menor elemento de la matriz.
                5.Muestra la matriz con las filas ordenadas de menor a mayor
                """);
        opcion = Integer.parseInt(sc.nextLine());
        switch (opcion){
            case 1:
                System.out.println("primera Columna a intercambiar");
                int pos1 = Integer.parseInt(sc.nextLine());
                System.out.println("segunda Columna a intercambiar");
                int pos2 = Integer.parseInt(sc.nextLine());
                intercambiarColumna(matriz, pos1, pos2);
                System.out.println("columnas intercambiadas!");
                pintarMatriz(matriz);
                break;
            case 2:
                int columna;
                System.out.println("Fila a sumar:");
                columna = Integer.parseInt(sc.nextLine());
                System.out.println("La suma de los valores de la fila es: "+sumarFila(matriz, columna));
                break;
            case 3:
                comprobarDiagonal(matriz);
                break;
            case 4:
                coordenadasMenor(matriz);
                break;
            case 5:
                ordenarFilas(matriz);
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

    //FUNCIONES

    public static void ordenarFilas(int[][]matriz){
        for(int i=0; i<matriz.length; i++){
            Arrays.sort(matriz[i]);
        }
        System.out.println("La matriz ordenada por filas de menor a mayor es:");
        pintarMatriz(matriz);

    }
    public static void coordenadasMenor(int[][] matriz){
        int menor = matriz[0][0];
        int fMenor=0;
        int cMenor=0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] < menor){
                    menor = matriz[i][j];
                    fMenor = i;
                    cMenor = j;
                }
            }
        }
        System.out.println("La coordenada del menor elemento es: ("+fMenor+","+cMenor+")");
    }
    public static void intercambiarColumna(int[][] matriz, int p1, int p2){
        int[] temp = new int[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            temp[i] = matriz[i][p1];
            matriz[i][p1] = matriz[i][p2];
            matriz[i][p2] = temp[i];

        }

    }
    public static int sumarFila(int[][] matriz, int fila){
        int suma = 0;
        fila --; //si elijes la fila 1, elijes la fila 0
        if (fila >= 0 && fila < 20){
            for (int i = 0; i < 1; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    suma += matriz[fila][j];
                }
            }
        } else
            System.out.println("Has elegido una fila incorrecta, prueba de nuevo...");
        return suma;
    }
    public static boolean comprobarDiagonal(int[][] matriz){
        //Comprueba si la diagonal principal y la inversa son iguales
        int[] diagonal = new int[20];
        int[] inversa = new int[20];
        for (int i = 0; i < matriz.length; i++) {
            diagonal[i] = matriz[i][i];
            inversa[i] = matriz[i][matriz.length - 1 - i];
        }
        System.out.println(Arrays.toString(diagonal));
        System.out.println(Arrays.toString(inversa));
        if (Arrays.equals(diagonal, inversa)){
            System.out.println("La diagonal principal y la inversa son iguales.");
            return true;
        } else {
            System.out.println("La diagonal principal y la inversa no son iguales.");
            return false;
        }
    }


public static int generarnumAleatorio(int menor, int mayor) {
    return (int) (Math.random() * (mayor - menor + 1) + menor);

}

public static void rellenarMatriz(int[][] matriz) {
    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz.length; j++) {
            matriz[i][j] = generarnumAleatorio(1,100);
        }
    }
}
public static void pintarMatriz(int matriz[][]) {
    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            System.out.print(matriz[i][j] + " ");
        }
        System.out.println();
    }
}
}


