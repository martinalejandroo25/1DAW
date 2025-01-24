package Programacion.Tema3.practicaArraysMatrices;

import java.util.Scanner;

public class Ejercicio4 {
    /*Programa Java para leer la altura de N personas y calcular la altura media. Calcular cuántas personas tienen una altura superior a la media y cuántas tienen una altura inferior a la media. El valor de N se pide por teclado y debe ser entero positivo.*/

    public static void main(String[] args) {
        System.out.println("Cuantas personas son para calcular la media de alturas?");
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] personas = new int[n];
        int superior=0;
        int inferior=0;
        int media1=0;
        int media2=0;
        for (int i = 0; i < n; i++) {
            System.out.println("Dame la altura en cm de la persona "+(i+1));
            personas[i] = Integer.parseInt(sc.nextLine());
            media1 += personas[i];
        }
        media2 = media1 / n;
        for (int i = 0; i < n; i++) {
            if (personas[i] > media2){
                superior++;
            } else if (personas[i] < media2) {
                inferior++;
            }
        }
        System.out.println("La media de altura es: "+media2);
        System.out.println("Hay "+superior+" personas que superan la media");
        System.out.println("Hay "+inferior+" personas que no llegan a la media");
    }
}
