package Programacion.Tema2.bucles.EjerciciosPDF;

import java.util.Scanner;

public class Ejercicio8 {
    public static void tablaMulti(int num){
        System.out.println("Tabla del "+ num);
        for (int i = 0; i < 11; i++) {
            System.out.println(num+" x "+ i +" = "+ (num * i));
        }
    }
    public static void main(String[] args) {
        // Programa que imprima la tabla de multiplicar de cualquier número entre el 1 y el 10 introducido por teclado.
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        tablaMulti(num);

    }
}
