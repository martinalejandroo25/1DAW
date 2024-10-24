package Programacion.Tema2.bucles.EjerciciosPDF;

import java.util.Scanner;

public class Ejercicio3 {
    /*Programa que lea un número positivo de un dígito por teclado y diga en letra a qué dígito corresponde
(uno, dos, tres, cuatro, …). Ejemplo: si se introduce el 1, se mostrará por pantalla el “uno”; si se introduce
el 11, se mostrará el mensaje “Error: no es un número de un dígito”.*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.println("Dame un numero de solo 1 digito");
        num = Integer.parseInt(sc.nextLine());
        switch (num) {
            case 1:
                System.out.println("uno");
                break;
            case 2:
                System.out.println("dos");
                break;
            case 3:
                System.out.println("tres");
                break;
            case 4:
                System.out.println("cuatro");
                break;
            case 5:
                System.out.println("cinco");
                break;
            case 6:
                System.out.println("seis");
                break;
            case 7:
                System.out.println("siete");
                break;
            case 8:
                System.out.println("ocho");
                break;
            case 9:
                System.out.println("nueve");
                break;
            case 0:
                System.out.println("cero");
                break;
            default:
                System.out.println("error, el numero no es correcto o es de mas de 1 digito");
        }
    }
}
