package Programacion.Tema2.bucles.EjerciciosPDF;

import java.util.Scanner;

public class Ejercicio21 {
    /*Pedir un número entero positivo N. A continuación, introducir por teclado N números enteros. Mostrar
la media de los N números introducidos, el mayor y el menor.*/
    public static void main(String[] args) {
        int num, conta = 0;
        int mayor = 0, menor = 0;
        int veces = 0, media;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Cuantos números vas a introducir?: ");
            veces = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < veces; i++) {
                System.out.println("introduce un número: "+"("+(i+1)+"/"+veces+")");
                num = Integer.parseInt(sc.nextLine());
                conta += num;
                if (num > mayor)
                    mayor = num;
                if (num < menor)
                    menor = num;


        media = conta / veces;
        System.out.println("El número mayor introducido es: "+mayor);
        System.out.println("El número menor introducido es: "+menor);
        System.out.println("La media es: "+media);
            }
        } catch (Exception e) {
            System.out.println("Has introducido un valor incorrecto");
        }
    }

}
