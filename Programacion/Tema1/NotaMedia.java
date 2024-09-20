package Programacion.Tema1;

import java.util.Scanner;

public class NotaMedia {
    //Media de notas
    /*Definición
            Datos de entrada: nota1, nota2, nota3
            Datos de salida: notaMedia
      * */
    /*Análisis
    *       Dadas 3 notas que corresponden a los exámenes de una asignatura, pide saber la nota media
    * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double nota1, nota2, nota3;

        System.out.println("Ingrese el primer nota: ");
        nota1 = sc.nextDouble();

        System.out.println("Ingrese la segundo nota: ");
        nota2 = sc.nextDouble();

        System.out.println("Ingrese el tercer nota: ");
        nota3 = sc.nextDouble();

        System.out.println("La nota media es de: "+ ((nota1+nota2+nota3)/3));
    }
}
