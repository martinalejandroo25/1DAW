package Programacion.Tema2.bucles.IfElse;

public class EjemploIF2 {
    public static void main(String[] args) {
        //Si la vida está por debajo de 50, pinta "toma poción de vida"
        //Si el mana está por debajo de 50, pinta "toma poción de maná"
        //Si ambos están por debajo de 50 pinta "CORRE"

        int vida = 45;
        int mana = 33;

        if(vida < 50){
            System.out.println("Necesitas una poción de salud");
        }
        if(mana < 50){
            System.out.println("Necesitas una pocion de mana");
        }
        if (mana < 50 && vida < 50){
            System.out.println("TU VIDA CORRE PELIGRO, CORRE");
        }
    }
}
