package Programacion.Tema2.bucles;

public class TablaMultiplicar {
    //Imprimir tabla multiplicar de 9

    public static void main(String[] args) {
        int  num = 9;

        for (int i = 0; i < 11; i++) {
            System.out.println ("---------------------------------------------------"+" Tabla del "+ i);
            for (int j = 0; j < 11; j++) {
                System.out.println(i + " x " + j +" = "+ (i*j));
            }
        }
    }
}
