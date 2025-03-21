package Programacion.Tema2.bucles.EjerciciosPDF;

import java.util.Scanner;

public class Ejercicio18 {
        /* CUBITUS Y HUMERUS
En este juego, en cada turno un jugador
lanza cuatro dados y se anota la suma de los valores impares obtenidos, mientras que el otro jugador
lanza tres dados y se anota la suma de los valores pares obtenidos. Gana el turno el jugador que obtenga
más puntos y gana la partida el jugador que haya ganado más turnos.*/
    //He hecho un copia y pega del ejercicio de la Actividad Evaluable que hicimos
        public static void main(String[] args) {
            // DECLARACION DE VARIABLES
            Scanner sc = new Scanner(System.in);
            int totalCubitus = 0, totalHumerus = 0, GanadosCubitus = 0, GanadosHumerus = 0;

            //PEDIR CANTIDAD DE TURNOS PARA LA PARTIDA
            System.out.println("Ingrese los turnos que vamos a jugar en esta partida: ");
            int turnos = Integer.parseInt(sc.nextLine());


            for (int i = 1; i <= turnos; i++) {
                System.out.println("----------- Turno "+i+" de Cubitus, 4 tiradas -----------");
                System.out.println();
                for (int j = 1; j <= 4 ; j++) {
                    System.out.println("tirada "+j+"/4 de Cubitus");
                    totalCubitus += tiradaCubitus();
                    System.out.println();
                }
                System.out.println("Puntos de este turno: "+totalCubitus);
                System.out.println();

                System.out.println("----------- Turno "+i+" de Humerus, 3 tiradas -----------");
                System.out.println();
                for (int j = 1; j <= 3 ; j++) {
                    System.out.println("tirada "+j+"/3 de Humerus");
                    totalHumerus += tiradaHumerus();
                    System.out.println();
                }
                System.out.println("Puntos de este turno: "+totalHumerus);
                System.out.println();
                if (totalCubitus > totalHumerus) {
                    GanadosCubitus++;
                } else if (totalHumerus > totalCubitus) {
                    GanadosHumerus++;
                }
                totalCubitus = 0;
                totalHumerus = 0;
            }
            System.out.println();
            System.out.println("-º-º-º-º-º-RESULTADOS DEL JUEGO-º-º-º-º-º-");
            System.out.println();
            System.out.println("Después de los "+turnos+" turnos, obtenemos el siguiente resultado:");
            System.out.println("Cubitus ha obtenido "+GanadosCubitus+" turnos ganados");
            System.out.println("Por otro lado, Humerus ha obtenido "+GanadosHumerus+" turnos ganados");
            if (GanadosCubitus > GanadosHumerus) {
                System.out.println("Por ende, el ganador indiscutible es Cubitus!");
            } else if (GanadosHumerus > GanadosCubitus) {
                System.out.println("Por ende, el ganador indiscutible es Humerus!");
            } else
                System.out.println("Parece que hemos obtenido un empate");
        }

    //FUNCIONES Y METODOS

    //GENERAR NUMERO ALEATORIO
    public static int generarnumAleatorio(int menor, int mayor) {
        int numero = (int) (Math.random() * (menor - mayor) + mayor);
        return numero;
    }

    //FUNCION QUE SIMULA 1 TIRADA DE CUBITUS
    public static int tiradaCubitus() {
        int tirada = generarnumAleatorio(1, 6);
        int total=0;
        if (((tirada) % 2) == 0 ) {
            System.out.println(tirada+" (Tirada no suma)");
        }
        else {

            System.out.println(tirada+" (Buena tirada, sumas)");
            total+= tirada;
        }


        return total;

    }

    //FUNCION QUE SIMULA 1 TIRADA DE HUMERUS
    public static int tiradaHumerus() {
        int tirada = generarnumAleatorio(1, 6);
        int total=0;
        if (((tirada) % 2) != 0 ) {
            System.out.println(tirada+" (Tirada no suma)");
        }
        else {
            System.out.println(tirada+" (Buena tirada, sumas)");
            total+= tirada;
        }

        return total;
    }

}
