package Programacion.Tema3.Matrices.EjerciciosClase;

import java.util.Scanner;

public class Enunciado1 {
    /*1. Conecta 4
Representa un tablero 6x7 que pueda contener los valores 0, 1 o 2.
Realiza un metodo:
    boolean colocarFicha(int tablero[][], int i, int j, int numJugador)

    - Ese metodo devolverá true, si en (i,j) hay un 0, está vacía,
    o si debajo no hay nada
    - Si numJugador==1 pondrá en esa casilla un 1
    - Si numJugador==2 pondrá en esa casilla un 2

Realiza un metodo para comprobar si algún jugador ha ganado:
    int comprobarGanador(int tablero[][])

    - Para ello debe haber cuatro casillas contiguas con 1 o con 2. Puede ser
    en horizontal, vertical o, si te animas, en diagonal.
    - Devolverá 0, si no hay ninguna
    - Devolverá 1, si hay cuatro 1 consecutivos
    - Devolvera 2, si hay cuatro 2 consecutivos

Intenta jugar una partida con dos jugadores, hasta que uno gane, o salir del juego*/
    public static void pintarMatriz(int matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean colocarFicha(int tablero[][], int i, int j,  int numJugador) {
      if(tablero[i][j] == 0) {
          if(numJugador == 1) {
              tablero[i][j] = 1;
          } else if (tablero[i][j] == 2) {
              tablero[i][j] = 2;
          }
          pintarMatriz(tablero);
          return true;
      } else {
          System.out.println("Este espacio ya está ocupado");
          return false;
      }
    }
    public static int[][] crearTablero(int tablero[][]) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = 0;
            }
        }
        return tablero;
    }
    public static boolean comprobarHV(int tablero[][], int jugador) {
        boolean ganador = false;

        //
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int jugador = 0;
        int columna = 0;
        int tablero[][] = new int[6][7];
       crearTablero(tablero);

        for (int i = 0; i < tablero.length; i++) {
            for (int j = tablero.length; j > 0 ; j--) {
                System.out.println("Jugador 1, elije columna para tirar ficha (1 al 7)");
                jugador = 1;
                columna = Integer.parseInt(sc.nextLine());
                if (columna >= 1 && columna <= 7) {

                    colocarFicha(tablero, i, j, jugador);
                }
                System.out.println("Jugador 2, elije columna para tirar ficha (1 al 7)");
                jugador = 2;
                columna = Integer.parseInt(sc.nextLine());
                if (columna >= 1 && columna <= 7) {
                    colocarFicha(tablero, i, j, jugador);
                }
            }
        }
    }
}
