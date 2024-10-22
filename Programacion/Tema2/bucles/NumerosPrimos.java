package Programacion.Tema2.bucles;

import java.util.Scanner;

public class NumerosPrimos {
    public static void main(String[] args) {
        /*
        * Introduce un numero y di si es un numero o no
        * Primo: solo divisible entre él mismo y el 1
        * Indicador
        * 7 -> 7/6 resto != 0, 7/4 resto != 0, ..., 7/2 != 0
        * // Si algún resto da == 0, significa que NO es primo
        * */
        boolean esPrimo = true;
        int num=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce numero");
        num = Integer.parseInt(sc.nextLine());

            for (int i = num-1; i >=2; i--) {
                if (num%i != 0) {
                    esPrimo = false;

                }
            }

            if (esPrimo) {
            System.out.println(num + "Es primo");
            } else
            System.out.println("no es primo");
    }
}
