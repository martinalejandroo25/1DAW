package Programacion.Tema2.bucles;

public class CubitusHumerus1 {
    public static void main(String[] args) {
        /*Dos romanos jugando dados
        * Cada uno tira un dado de 20 caras
        * Gana el que saca el dado mayor, o el si alguno de ellos saca el 9
        * Juega una partida y dime quien gana*/


        int contaH=0;
        int contaC=0;


        for (int i = 0; i < 11; i++) {
            int tiradaCubitus = (int) (Math.random() * 20) + 1;
            int tiradaHumerus = (int) (Math.random() * 20) + 1;

            System.out.println("El dado de Cubitus ha dado "+tiradaCubitus);
            System.out.println("El dado de Humerus ha dado "+tiradaHumerus);

            if ( (tiradaHumerus == 9) && (tiradaCubitus != 9) ) {
                System.out.println("Gana Humerus");
                contaH++;
            } else if ( (tiradaCubitus == 9) && (tiradaHumerus != 9) ) {
                System.out.println("Gana Cubitus");
                contaC++;
            } else if ( (tiradaCubitus == 9) && (tiradaHumerus == 9) ) {
                System.out.println("Empate");
            } else if (tiradaCubitus > tiradaHumerus) {
                System.out.println("Gana Cubitus");
                contaC++;
            } else if (tiradaHumerus > tiradaCubitus) {
                System.out.println("Gana Humerus");
                contaH++;
            } else if (tiradaCubitus == tiradaHumerus) {
                System.out.println("Empate");
            }

        }
        if (contaC > contaH)
            System.out.println("El ganador de las 10P es Cubitus con "+contaC+" Partidas ganadas");
         else if (contaC > contaH)