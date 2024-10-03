package Programacion.Tema1;

import java.util.Scanner;

public class Ejercicio2Clase {
    public static void main(String[] args) {
        /*Un alumno quiere saber su nota final de programación
        * tres examenes parciales: nota1,nota2,nota3 => 55%
        * examen final: notaExamenFinal => 30%
        * trabajoFinal: notaTrabajoFinal => 15%
        * */
        double n1, n2, n3, nFinal, TFinal;
         Scanner sc = new Scanner(System.in);
        System.out.println("Escribe la nota del primer exámen");
        n1 = sc.nextDouble();
        System.out.println("Escribe la nota del segundo examen");
        n2 = sc.nextDouble();
        System.out.println("Escribe la nota del tercer examen");
        n3 = sc.nextDouble();
        System.out.println("Escribe la nota del Examen final");
        nFinal = sc.nextDouble();
        System.out.println("Por ultimo, escribe la nota del trabajo final");
        TFinal = sc.nextDouble();

        System.out.println("La nota media que has sacado es de "+ ((((n1+n2+n3)*0.55)/3)+(nFinal*0.3)+(TFinal*0.15)));
    }
}
