package Programacion.Tema5.BladeOfDarkness;

public class  TestJuego {
    public static void main(String[] args) throws Exception {
        Jugador jugador = new Jugador("Jugador 1", 4, 50);

        Arma espada = new Arma("Espada Gen", 34, false);
        Arma martillo = new Arma("Martillo Gen", 67, true);

        Monstruo m1 = new Monstruo("Monstruo1", 15, 50, 20);
        Monstruo m2 = new Monstruo("Monstruo2", 10, 50, 20);
        Monstruo m3 = new Monstruo("Monstruo3", 24, 50, 20);
        Monstruo m4 = new Monstruo("Monstruo4", 3, 50, 20);

        m1.setNivel(3);
        m1.setSalud(200);
        jugador.setArmaDerecha(espada);
        System.out.println(jugador);
        System.out.println(m1);

        System.out.println("El jugador va a golpear al monstruo");
        jugador.golpear(m1);
        jugador.golpear(m1);
        jugador.golpear(m1);
        jugador.golpear(m1);
        jugador.golpear(m1);
        jugador.golpear(m1);
        jugador.golpear(m1);
        jugador.golpear(m1);
        jugador.golpear(m1);
        System.out.println("la vida del monstruo restante es de" + m1.getSalud());
        System.out.println("El monstruo va a atacar");
        m1.golpear(jugador);
        m1.golpear(jugador);
        m1.golpear(jugador);
        m1.golpear(jugador);
        System.out.println("Vida restante:"+ jugador.getSalud());
    }
}
