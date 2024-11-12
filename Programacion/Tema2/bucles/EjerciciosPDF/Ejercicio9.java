package Programacion.Tema2.bucles.EjerciciosPDF;

import java.util.Scanner;

public class Ejercicio9 {
    // Crea un método que, dado un número entero pasado como parámetro, devuelva cuántos dígitos lo forman.
    // P.ej.: el número 54326 consta de 5 dígitos. Pista: cuántas veces se puede dividir entre 10.
    public static int digitos(int num){
        int conta = 1;
        while((num / 10) > 1){
            num = num / 10;
            conta++;
        }
        return conta;
    }

    public static void main(String[] args) {
        System.out.println("Escribe un numero para saber cuantos digitos tiene:");
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        System.out.println("El numero "+num+" tiene "+digitos(num)+" digitos");
    }
}
