package Programacion.Examen1Evaluacion;

import java.util.Scanner;

public class Ejercicio4 {
    /* Escribe un programa en Java que simule un juego de la Caza del Tesoro. En este
juego, el tablero estará representado por una matriz 10x10 y el objetivo es encontrar el
tesoro escondido en una de las celdas del tablero. El jugador debe ingresar coordenadas
para intentar encontrar el tesoro.
Reglas del juego:
a. El tablero tiene dimensiones de 10x10, inicialmente vacías ‘-’.
b. Se coloca un tesoro en una casilla aleatoria del tablero.
c. El jugador hará intentos para localizar el tesoro, dando la coordenada x y la
coordenada y donde cree que está el tesoro.
d. El jugador tiene 15 intentos para encontrar el tesoro.
e. Después de cada intento, el juego dará pistas:
• Si el jugador dispara a una casilla más cerca del tesoro (en términos de
distancia), se le da la pista "Estás más cerca del tesoro".
• Si el jugador dispara a una casilla más alejada, se le da la pista "Estás más lejos
del tesoro".
• La distancia puede calcularse usando la distancia de Manhattan que se calcula
como la suma del valor absoluto de la resta de las coordenadas x, más el valor
absoluto de la resta de las coordenadas y. Donde (x1,y1) es el punto donde está
el tesoro, y (x2,y2) es el punto donde tú pruebas.
Distancia = ∣x1 − x2∣ + ∣y1 − y2∣
f.g.h.El programa debe mostrar el estado del tablero después de cada disparo, con las
casillas marcadas como "descubiertas" o "fallos".
El jugador debe seguir intentando hasta encontrar el tesoro o agotar sus intentos.
Si el jugador encuentra el tesoro, el juego termina y se muestra un mensaje de*/
    public static void main(String[] args) {
        char[][] tablero = new char[10][10];
        int distancia = 0;
        int intentos = 15;
        int fila = generarnumAleatorio(0, tablero.length);
        int columna = generarnumAleatorio(0, tablero.length);
        boolean encontrado = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Mensaje de prueba el tesoro está en ("+fila+", "+columna+")");
        System.out.println("CAZA DEL TESORO--------------------------------");
        rellenarTablero(tablero);
        pintarMatriz(tablero);
        char tesoro = colocarTesoro(tablero, fila, columna);

        for (int i = intentos; i >= 0; i--) {
        System.out.println("Dime en qué coordenadas crees que está el tesoro");
        System.out.println("coordenada X");
        int x = Integer.parseInt(sc.nextLine());
        System.out.println("coordenada Y");
        int y = Integer.parseInt(sc.nextLine());
            if (IntentoDeEncuentro(tablero, x, y, fila, columna)){
            } else {
                System.out.println("Has fallado... Tienes "+i+" intentos restantes");
                CercaLejos(fila, columna, x, y, distancia);
            }
            if (i == 0){
                System.out.println("Has agotado todos tus intentos... Tas quedao pobre pa toa tu vida");
            }
        }

    }

    //FUNCIONES
    public static void pintarMatriz(char matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    //El tablero tiene dimensiones de 10x10, inicialmente vacías ‘-’.
    public static void rellenarTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    //Se coloca un tesoro en una casilla aleatoria del tablero
    public static char colocarTesoro(char[][] tablero, int fila, int columna) {
        return tablero[fila][columna];
    }

    public static int generarnumAleatorio(int menor, int mayor) {
        return (int) (Math.random() * (mayor - menor + 1) + menor);

    }
    public static boolean IntentoDeEncuentro(char[][] tablero, int x, int y, int fila, int columna){
        if (x == fila && y == columna){
            System.out.println("Lo has conseguido!! Tesoro encontrado >:)");
            tablero[fila][columna] = 'X';
            pintarMatriz(tablero);
            return true;
        } else {
            tablero[x][y] = 'O';
            pintarMatriz(tablero);
            return false;
        }

    }
    public static void CercaLejos(int f, int c, int x, int y, int distancia){
      //∣x1 − x2∣ + ∣y1 − y2∣
        int Nuevadistancia = (f - x)+(c - y);
      if( Nuevadistancia > distancia){
          System.out.println("Estas más lejos del tesoro");
      } else if (Nuevadistancia < distancia){
          System.out.println("Estas más cerca del tesoro");


      }
    }
}
