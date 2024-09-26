package Programacion.Tema1;

import java.util.Scanner;

public class PrecioIVA {
    public static void main(String[] args) {
        //Crea un programa que lea por teclado el precio de un producto
        //Pide tambien la cantidad de ese producto a comprar
        // Devuelve el precio final con el iva 21%

        //declaracion de variables
        Scanner sc = new Scanner(System.in);
        double precio=0;
        double precioIVA=0;
        double cantidad=0;
        System.out.println("Ingrese el precio para sumar el IVA");
        precio= sc.nextDouble();
        precioIVA = precio*1.21;
        System.out.println("ingresa la cantidad de producto que has comprado: ");
        cantidad= sc.nextDouble();
        System.out.println("el precio con el IVA añadido es de "+precioIVA+"€");
        System.out.println("el total de la compra es de "+(precioIVA*cantidad)+"€");
        
    }
}
