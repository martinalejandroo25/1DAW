package Programacion.Tema2.bucles;

public class EjerciciosWhile {
    public static void main(String[] args) {

        //Simula lanzar un dado de seis caras, hasta que te salga un seis
        //Generar un número aleatorio del 1 al 6

        int tirada = 0;
        int conta=0;
        while(tirada != 1 && tirada != 20) {
            tirada = (int) (Math.random() * 20 - 1 + 1) + 1;
            System.out.println(tirada);
            conta++;
        }
        System.out.println("Se han necesitado " + conta+" tiradas");
    }
}
