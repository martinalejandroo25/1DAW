package Programacion.Tema1.EjerciciosPDF;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        String nombre;
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cual es tu nombre?");
        nombre = sc.nextLine();
        System.out.println("holaa, ¿que tal todo "+nombre+"?");
    }
}
