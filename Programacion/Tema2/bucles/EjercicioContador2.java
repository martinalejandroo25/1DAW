package Programacion.Tema2.bucles;

import java.util.Scanner;

public class EjercicioContador2 {
    public static void main(String[] args) {
        // Pide 5 precios por teclado
        // imprime el total
        Scanner sc = new Scanner(System.in);
        double precio;
        double total=0;
        for (int i = 0; i < 5; i++) {
            System.out.println("Dame el precio "+ i);
            precio = Double.parseDouble(sc.nextLine());
            total = total + precio;
        }
        System.out.println("El total es de: "+total+"€");
    }
}
