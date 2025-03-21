package Programacion.Tema2.bucles.EjerciciosPDF;

import java.util.Scanner;

public class Ejercicio16 {
    public static void main(String[] args) {
        /*Programa que lea por teclado una serie de números enteros hasta que introduzca el -1 y obtenga su
media. Deberá mostrarla por pantalla.*/
        int num = 0, suma = 0;
        int media = 0, conta = 0;
        Scanner sc = new Scanner(System.in);
        while(num != -1){
            System.out.println("Ingrese un numero, el programa hará la media de todos los numeros cuando se ingrese -1");
            num = Integer.parseInt(sc.nextLine());
            if (num != -1){
                suma += num;
                conta++;
                media = suma/conta;
            }
        }
        System.out.println("La media queda en: "+media);
    }
}
