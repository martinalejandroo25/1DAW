package Programacion.Tema2;

import java.util.Scanner;

public class EjercicioIfElse {
    public static void main(String[] args) {

        //pedir por teclado la hora del dia
        //6-12 Buenos días
        //12-20 Buenas tardes
        //En otro caso buenas noches

        //Pedir nivel del jugador
        //1-5:
            /*
            * 1.iniciado
            * 2.amateur
            * 3.profesional
            * 4.experto
            * 5.Dios
            * */

        //Buenos días jugador de nivel iniciado
        //Buenas tardes jugador de nivel experto
        //...
        int hora, nivel;
        String mensaje1 = "error";
        String mensaje2 = "error";
        Scanner sc = new Scanner(System.in);
        System.out.println("que hora es?");
        hora = sc.nextInt();
        System.out.println("Cual es tu nivel de jugador del 1 al 5?");
        nivel = sc.nextInt();
        if (hora >= 6 && hora <= 12) {
            mensaje1 = "Buenos días";
        }
        else if (hora > 12 && hora <= 20) {
            mensaje1 = "Buenos tarde";
        }
        else {
            System.out.println("Buenas noches");
        }

       if (nivel == 1){
           mensaje2 = "jugador de nivel iniciado";
       }
       else if (nivel == 2){
           mensaje2 = "jugador de nivel amateur";
       } else if (nivel == 3) {
           mensaje2 = "jugador de nivel profesional";
       }
       else if (nivel == 4){
           mensaje2 = "jugador de nivel experto";
       }
       else if (nivel == 5){
           mensaje2 = "jugador de nivel Dios";
       }
        System.out.println(mensaje1 + " " + mensaje2);
    }
}
