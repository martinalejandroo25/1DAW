package Programacion.Tema5.BladeOfDarkness;

public class TestJuego {
    public static void main(String[] args) {
        Jugador jugador = new Jugador("Jugador 1");

        Arma espada = new Arma("Espada Gen", 2, false);
        Arma martillo = new Arma("Martillo Gen", 4, true);

        Monstruo m1 = new Monstruo("Monstruo1", 5);
        Monstruo m2 = new Monstruo("Monstruo2", 6);
        Monstruo m3 = new Monstruo("Monstruo3", 8);
        Monstruo m4 = new Monstruo("Monstruo4", 3);


    }
}
