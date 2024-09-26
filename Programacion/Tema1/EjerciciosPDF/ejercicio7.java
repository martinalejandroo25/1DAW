package Programacion.Tema1.EjerciciosPDF;

import java.util.Scanner;

public class ejercicio7 {
    //Una tienda ofrece un descuento del 15% sobre el total de la compra y un cliente desea saber cuanto debera pagar finalmente por su compra
    public static void main(String[] args) {
        double precioSIN;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el total de compra antes de aplicar el descuento");
        precioSIN = sc.nextDouble();
        System.out.println("El precio con el 15% aplicado es de: ");
        System.out.println(((precioSIN)*(1-0.15)));
    }
}
