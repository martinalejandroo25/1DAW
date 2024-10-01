package Programacion.Tema1;

import java.util.Scanner;

public class Ejercicio1OW {
    public static void main(String[] args) {
        /*Pedimos por teclado el coste de fabricación de un producto
        * Queremos pintar por pantalla el precio que le vamos a poner al producto para el cliente
        * Al coste de fabricación hay que sumarle la ganacia para el vendedor(30%)
        * Al precio resultante lo que tengo que sumar es el IVA(21)
        * Por último imprimo por pantalla el precio para el cliente final
        * */

        double precioFabricacion;
        double precioIVA;
        Scanner sc = new Scanner(System.in);
        System.out.println("Cual es el coste de fabricación del producto?");
        precioFabricacion = sc.nextDouble() * 1.3; //al coste de fabricación le añadimos la ganacia del 30%
        System.out.println(precioFabricacion);
        precioIVA = precioFabricacion * 1.21;
        System.out.println("el precio para el cliente final se quedaría en: "+precioIVA+" €");
    }
}
