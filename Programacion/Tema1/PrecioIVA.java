package Programacion.Tema1;

import java.util.Scanner;

public class PrecioIVA {
    public static void main(String[] args) {
        //dado un precio añadir el iva

        //declaracion de variables
        Scanner sc = new Scanner(System.in);
        double precio=0;
        double precioIVA=0;
        System.out.println("Ingrese el precio IVA");
        precio= sc.nextDouble();
        precioIVA = precio*1.21;
        System.out.println("el precio con el IVA añadido es de "+precioIVA);
    }
}
