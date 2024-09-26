package Programacion.Tema1.EjerciciosPDF;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Ejercicio2 {
    //Calcula el perimetro y area de un rectangulo dada su base y su altura
    public static void main(String[] args) {
        double perimetro, area, base, altura;
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame la base del rectangulo:");
        base = sc.nextDouble();
        System.out.println("Dame la altura del rectangulo:");
        altura = sc.nextDouble();
        area = base * altura;
        perimetro = 2*(base+altura);
        System.out.println("El perimetro es: " + perimetro);
        System.out.println("El area es: " + area);

    }
}
