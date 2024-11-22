package Programacion.Tema3.practica1;

public class Ejercicio12 {

    public static void pintar(int matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int matrizMarco[][] = new int[10][5];

        for (int i = 0; i < matrizMarco.length; i++) {
            for (int j = 0; j < matrizMarco[0].length; j++) {
                // Primera y última fila
                if (i == 0 || i == matrizMarco.length - 1 ) {
                    matrizMarco[i][j] = 1;
                }
                // Primera y última columna
                if (j == 0 || j == matrizMarco[0].length - 1) {
                    matrizMarco[i][j] = 1;
                }
            }
        }
        pintar(matrizMarco);
    }
}
