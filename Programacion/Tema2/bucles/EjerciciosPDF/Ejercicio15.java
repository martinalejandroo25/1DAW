package Programacion.Tema2.bucles.EjerciciosPDF;

import java.util.Scanner;

public class Ejercicio15 {
    public static void main(String[] args) {
        /*Programa que lea números hasta que le den el cero, y que diga cuál ha sido el mayor y cuál el menor de los números introducidos (sin tener en cuenta el cero).*/
        int num=1;
        int mayor=1, menor=1;
        Scanner sc = new Scanner(System.in);
        while(num != 0){
            System.out.println("Ingresa un número, cuando lea 0 el programa finalizará");
            num = Integer.parseInt(sc.nextLine());
            if (mayor < num && num != 0)
                mayor = num;
            if (menor > num && num != 0)
                menor = num;

        }
        System.out.println("El menor de los numeros introducidos es el "+menor);
        System.out.println("El mayor de los numeros introducidos es el "+mayor);
    }
}
