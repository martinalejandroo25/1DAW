package Programacion.Tema4.EjerciciosObjetosPOO.Ejercicio1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        double faren, celsius;
        int opcion;
        Scanner sc = new Scanner(System.in);
        System.out.println("1 para pasar de Celsius a Fahrenheit");
        System.out.println("2 para pasar de Fahrenheit a Celsius");
        opcion = Integer.parseInt(sc.nextLine());
        switch (opcion) {
            case 1:
                System.out.println("Inserta la temperatura en Celsius");
                celsius = Double.parseDouble(sc.nextLine());
                System.out.println(celsius+"ºC se pasarían a: "+Temperatura.celsiusToFarenheit(celsius)+"F");
                break;
            case 2:
                System.out.println("Inserta la temperatura en Fahrenheit");
                faren = Double.parseDouble(sc.nextLine());
                System.out.println(faren+"F se pasarían a: "+Temperatura.farenheitToCelsius(faren)+"F");
                break;
        }
    }
}
