package Programacion.Tema2.bucles.EjerciciosPDF;

import java.util.Scanner;

public class Ejercicio4 {
    /*Crea una función que no devuelva nada (void) que, dado un importe en euros, nos indique el mínimo
número de billetes y la cantidad sobrante que se pueden utilizar para obtener dicha cantidad. Ejemplo:
362 euros → 1 billete de 200, 1 billete de 100, 1 billete 50, un billete de 10, sobran 2 euros. Pista: hay
que ir sacando la división entera, y el resto se lleva al siguiente billete.*/
    public static void billete(int euros){
        int total = euros;
        int billeteQ = euros / 500;
        euros = euros % 500;
        int dosC = euros / 200;
        euros = euros % 200;
        int cien = euros / 100;
        euros = euros % 100;
        int cincuenta = euros / 50;
        euros = euros % 50;
        int veinte = euros / 20;
        euros = euros % 20;
        int diez = euros / 10;
        euros = euros % 10;
        int cinco = euros / 5;
        euros = euros % 5;
        int sobrante = euros;
        System.out.println(total+" euros →"+billeteQ+" billete de 500,"+dosC+" billete de 200, "+cien+" billete de 100, "+cincuenta+" billete 50, "+veinte+" billete de 20,"+diez+" billete de 10,"+cinco+" billete de 5, sobran "+sobrante+" euros");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero de euros");
        int euros = Integer.parseInt(sc.nextLine());
        billete(euros);

    }
}
