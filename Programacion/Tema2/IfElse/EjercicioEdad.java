package Programacion.Tema2.bucles.IfElse;

import java.util.Scanner;

public class EjercicioEdad {
    /* edad:
    *   1 al 11 -> hola niño
    *   12 al 18 -> hola chaval
    *   19 al 29 -> hola tio
    *   30 al 60 -> hola hombre
    *   >60      -> hola abuelo
    * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Que edad tienes?");
        int edad = sc.nextInt();
        System.out.println("Cual es tu sexo? H, M, O");
        char sexo = sc.next().charAt(0);

        if (sexo == 'H' || sexo == 'h') {
            if (edad >= 1 && edad <= 11) {
                System.out.println("Hola niño");
            }
            if (edad >= 12 && edad <= 18) {
                System.out.println("Hola chaval");
            }
            if (edad >= 19 && edad <= 29) {
                System.out.println("Hola tio");
            }
            if (edad >= 30 && edad <= 60) {
                System.out.println("Hola hombre");
            }
            if (edad >= 61) {
                System.out.println("Hola abuelo");
            }
        }
        if (sexo == 'M' || sexo == 'm') {
            if (edad >= 1 && edad <= 11) {
                System.out.println("Hola niña");
            }
            if (edad >= 12 && edad <= 18) {
                System.out.println("Hola chavala");
            }
            if (edad >= 19 && edad <= 29) {
                System.out.println("Hola tia");
            }
            if (edad >= 30 && edad <= 60) {
                System.out.println("Hola mujer");
            }
            if (edad >= 61) {
                System.out.println("Hola abuela");
            }
        }
        if (sexo == 'O' || sexo == 'o'){
            System.out.println("Te damos la bienvenida");
        }
    }
}
