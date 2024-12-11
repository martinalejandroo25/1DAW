package Programacion.PracticaAntesExamen;

public class Laberinto {
    public static void main(String[] args) {
        char[][] laberinto = new char[20][20];
        generarLab(laberinto);
        pintarLab(laberinto);
    }

    public static void generarLab(char[][] lab) {
        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab.length; j++) {
                lab[0][j] = '-';
                lab[i][j] = '·';
                lab[i][0] = '|';
                lab[19][j] = '-';
                lab[i][19] = '|';
            }
        }
    }
    public static void pintarLab(char matriz[][]){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j]);

            }
        }
    }
}
