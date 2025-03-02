package Programacion.Tema5.EjerciciosPOOpdf.Ejercicio1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Nombre de la Persona");
        String nombre = sc.nextLine();
        System.out.println("edad de " + nombre);
        int edad = Integer.parseInt(sc.nextLine());
        System.out.println("DNI de " + nombre);
        String dni = sc.nextLine();
        System.out.println("Sexo de " + nombre + " (H hombre, M mujer, O otro)");
        String sexo = sc.nextLine();
        System.out.println("peso de " + nombre + " en kg");
        double peso = Double.parseDouble(sc.nextLine());
        System.out.println("altura de " + nombre + "en m (0.00)");
        double altura = Double.parseDouble(sc.nextLine());

        Persona persona = new Persona(nombre, edad, dni, sexo, peso, altura);
        System.out.println(persona.toString());

    }
}
