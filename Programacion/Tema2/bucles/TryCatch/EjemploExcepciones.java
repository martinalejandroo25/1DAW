package Programacion.Tema2.bucles.TryCatch;

import java.util.Scanner;

public class EjemploExcepciones {
    public static void main(String[] args) {
        /*
        * Vamos a pedir un precio por teclado y vamos a mostrar el precio con IVA(21%)
        * Controlar que el precio sea un double y no escriba otra cosa
        * Controlar si es un número negativo vamos a lanzar una excepción (no importante)
        * double precio;
        * */
        double precio=0;

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Ingrese el precio del producto: ");
            precio = Double.parseDouble(sc.nextLine());
            System.out.println("El precio con IVA es: " + precio * 1.21 );
        } catch (Exception e) {
            System.out.println("No has introducido un decimal para el precio");
        }


    }
}
