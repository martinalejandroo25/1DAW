package Programacion.Tema2.bucles;

public class EjercicioContador {
    public static void main(String[] args) {

        //Tira un dado de seis caras 100 veces y dime cuantas veces sale el 6

        int tirada;
        int conta = 0;
        for (int i = 0; i < 100; i++) {
            tirada = (int) (Math.random() * 6) + 1;
            System.out.println(tirada + " tirada numero "+ i);
            if (tirada == 6) {
                conta++;
            }
        }
        System.out.println("El numero de 6 es: "+ conta);
    }
}
