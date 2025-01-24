package Programacion.Examen1Evaluacion;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Ejercicio2 {
    /*El Reino de los Dados Mágicos
Dos jugadores se enfrentan en un duelo usando dados mágicos con poderes especiales.
Cada ronda introduce una regla especial que puede cambiar la puntuación o las
condiciones del duelo.
Preparación inicial:
• Se decide el número de rondas (mínimo 5).
• Los jugadores usan dados de 6 caras.
Desarrollo de cada ronda:
• Antes de lanzar los dados, se selecciona una regla mágica de forma aleatoria.
• Ambos jugadores lanzan su dado, y el resultado se interpreta según la regla mágica
de esa ronda.
• Según el resultado, los jugadores pueden ganar o perder puntos de vida.
Reglas mágicas posibles (se elige una al azar en cada ronda):
• Dado de Fuego: El perdedor (menor resultado) de la ronda pierde tantos puntos de
vida como la diferencia entre ambos resultados.
• Dado de Curación: Ambos jugadores suman el resultado de su dado a su vida.
• Dado de Robo: El jugador con el dado más alto roba puntos de vida al otro igual a la
mitad de su resultado (redondeado hacia abajo).
• Dado Explosivo: Si un jugador saca un 6, el otro pierde automáticamente 10 puntos
de vida. Si ambos sacan 6, se anula el efecto.
• Dado de Escudo: En esta ronda, ningún jugador pierde puntos de vida, pero el
ganador (mayor puntuación) recibe un "escudo" que le protege de daño en la
siguiente ronda.
Final del juego:
• El duelo termina si uno de los jugadores llega a 0 puntos de vida. El otro será el
ganador.
• Si se completan todas las rondas y ambos siguen vivos, gana el jugador con más
puntos de vida.*/
    public static void main(String[] args) {
        /*Dos jugadores se enfrentan en un duelo usando dados mágicos con poderes especiales.
Cada ronda introduce una regla especial que puede cambiar la puntuación o las
condiciones del duelo.*/
        // Declaracion de variables

        //Ambos jugadores comienzan con 40 puntos de vida.
        int jugador1 = 40;
        int jugador2 = 40;

        int tirada1;
        int tirada2;

        boolean escudoJugador1=false;
        boolean escudoJugador2=false;
        Scanner sc = new Scanner(System.in);

        // Se decide el número de rondas (mínimo 5).
        System.out.println("Cuantas rondas se van a jugar? minimo 5");
        int rondas = Integer.parseInt(sc.nextLine());
        if (rondas < 5){
            rondas = 5;
        }

        for (int i = 0; i < rondas; i++) {
            System.out.println("RONDA NÚMERO " + (i+1)+" --------------------------------");
            System.out.println("Vida restante de Jugador 1: "+jugador1);
            System.out.println("Vida restante de Jugador 2: "+jugador2);
            System.out.println();
            tirada1 = lanzarDados();
            System.out.println("Tirada del Jugador 1: "+tirada1);
            tirada2 = lanzarDados();
            System.out.println("Tirada del Jugador 2: "+tirada2);
            System.out.println();

            // Eleccion de los dados aleatoriamente
            int regla = generarnumAleatorio(1,5);

            switch (regla) {
                case 1:
                    System.out.println("Regla Aleatoria seleccionada: ");
                    System.out.println("Dado de Fuego");
                    if (tirada1 < tirada2){
                        jugador1 = ReglaFuego(jugador1, tirada1, tirada2, escudoJugador1);
                        System.out.println("El jugador 1 pierde "+(tirada2 - tirada1)+" puntos de vida");
                    } else if (tirada2 < tirada1){
                        jugador2 = ReglaFuego(jugador2, tirada2, tirada1, escudoJugador2);
                        System.out.println("El jugador 2 pierde "+(tirada1 - tirada2)+ " puntos de vida");
                    }
                    break;
                case 2:
                    System.out.println("Regla Aleatoria seleccionada: ");
                    System.out.println("Dado de Curación");
                    jugador1 = ReglaCuracion(jugador1, tirada1);
                    System.out.println("El jugador 1 recupera "+tirada1+" puntos de vida");
                    jugador2 = ReglaCuracion(jugador2, tirada2);
                    System.out.println("El jugador 2 recupera "+tirada2+" puntos de vida");
                    break;
                case 3:
                    System.out.println("Regla Aleatoria seleccionada: ");
                    System.out.println("Dado de Robo");
                    int Robo[] = ReglaRobo(jugador1, jugador2, tirada1, tirada2, escudoJugador1);
                    jugador1 = Robo[0];
                    jugador2 = Robo[1];
                    break;
                case 4:
                    System.out.println("Regla Aleatoria seleccionada: ");
                    System.out.println("Dado Explosivo");
                    if (tirada1 < tirada2){
                        jugador1 = ReglaExplosivo(jugador1, tirada1, tirada2, escudoJugador1);
                        System.out.println("El jugador 1 pierde "+(tirada2 - tirada1)+" puntos de vida");
                    } else if (tirada2 < tirada1){
                        jugador2 = ReglaExplosivo(jugador2, tirada2, tirada1, escudoJugador2);
                        System.out.println("El jugador 2 pierde"+(tirada1 - tirada2)+ " puntos de vida");
                    }
                    break;
                case 5:
                    System.out.println("Regla Aleatoria seleccionada: ");
                    System.out.println("Dado de Escudo");
                    if (Escudo(tirada1, tirada2)){
                        System.out.println("Jugador 1 obtiene Escudo");
                        escudoJugador1 = true;
                    } else if (Escudo(tirada2, tirada1))
                        System.out.println("Jugador 2 obtiene Escudo");
                    escudoJugador2 = true;
                    break;
            }

        }
        ganador(jugador1, jugador2);
    }
    // FUNCIONES


    public static int lanzarDados(){
        int tirada = generarnumAleatorio(1,6);
        return tirada;
    }

    //Dado de Escudo: En esta ronda, ningún jugador pierde puntos de vida, pero el
    //ganador (mayor puntuación) recibe un "escudo" que le protege de daño en la
    //siguiente ronda.
    public static boolean Escudo(int t1, int t2){
        return t1 > t2;
    }

    //Reglas mágicas posibles (se elige una al azar en cada ronda):
    //• Dado de Fuego: El perdedor (menor resultado) de la ronda pierde tantos puntos de vida como la diferencia entre ambos resultados.
    public static int ReglaFuego(int j, int t1, int t2, boolean escudo) {
            if(!escudo) {
                j = j - (t2 - t1);
            }else if (escudo) {
                System.out.println("Escudo activado, el jugador es inmune en este turno");
                escudo = false;
            }
            return j;
    }
    //• Dado de Curación: Ambos jugadores suman el resultado de su dado a su vida.
    public static int ReglaCuracion(int j, int t){
        j = j + t;
        return j;
    }
    //• Dado de Robo: El jugador con el dado más alto roba puntos de vida al otro igual a la
    //mitad de su resultado (redondeado hacia abajo).
    public static int[] ReglaRobo(int j1, int j2, int t1, int t2, boolean escudo){
        if (!escudo){
            if (t1 > t2){
                System.out.println("jugador 1 roba vida");
                j1 += (t1/2);
                j2 -= (t1/2);
            } else if (t1 < t2){
                System.out.println("Jugador 2 roba vida");
                j1 -= (t2/2);
                j2 += (t2/2);
            }
            return new int[]{j1, j2};
        } else {
            System.out.println("Escudo activado, el jugador es inmune en este turno");
            escudo = false;
            return new int[]{j1, j2};
        }

    }
    //• Dado Explosivo: Si un jugador saca un 6, el otro pierde automáticamente 10 puntos
    //de vida. Si ambos sacan 6, se anula el efecto.
    public static int ReglaExplosivo(int j, int t1, int t2, boolean escudo){
        if (t1 == 6 || t2 == 6){
            j = j - 10;
        } else if (escudo) {
            System.out.println("Escudo activado , el jugador es inmune en este turno");
            escudo = false;
        }
        else
            System.out.println("Efecto anulado");
        return j;
    }
    public static int generarnumAleatorio(int menor, int mayor) {
        return (int) (Math.random() * (mayor - menor + 1) + menor);
    }

    public static void ganador(int j1, int j2){
        if (j1 > j2){
            System.out.println("El ganador de la partida es JUGADOR 1");
        } else if (j2 > j1)
            System.out.println("El ganador de la partida es JUGADOR 2");
        else System.out.println("Ha habido un empate entre los jugadores!");
    }

}
