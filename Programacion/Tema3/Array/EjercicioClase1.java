package Programacion.Tema3.Array;

import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioClase1 {
    public static void main(String[] args) {
        //Pide 5 números double por teclado
        //Guárdalos directamente en un array
        //Pinta el array entero

        //Variables, sc tipo scanner, numeros de tipo array

        Scanner sc = new Scanner(System.in);
        int numero[] = new int[5];
        for (int i = 0; i < numero.length; i++) {
            System.out.println("Dame un numero: "+(i+1)+"/5");
            numero[i] = Integer.parseInt(sc.nextLine());
        }
        for (int i = 0; i < numero.length; i++) {
            System.out.print("["+numero[i]+"], ");
        }
    }
}
