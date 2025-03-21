package Programacion.Tema2.bucles.IfElse;

public class EjemploIF3 {
    //vidaP, magiaP, escudoEspecial (boolean)
    //Si vidaP es menor que 50 y no tiene escudo pinta Toma Poción
    //Sino si magia es menor que 50 y no tiene Escudo, toma pocion magia
    //sino si vidaP es menor que 50 y magia es menor que 50 -> tómate algo y corre


    public static void main(String[] args) {
        int vidaP = 30;
        int magiaP = 30;
        boolean escudoEspecial = true;

        if(vidaP < 50 && escudoEspecial == false) {
            System.out.println("Toma pocion de vida");
        }
        if (magiaP < 50 && escudoEspecial == false) {
            System.out.println("Toma poción de magia");
        }
        if (vidaP < 50 && magiaP < 50) {
            System.out.println("Tómate algo y corre");
        }

    }
}
