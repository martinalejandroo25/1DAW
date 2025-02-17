package Programacion.Tema5.AcademiaDeMagia;

import java.util.ArrayList;
import java.util.List;

public class TestJuego {
    public static void main(String[] args) {
        List<Hechizo> hechizos = new ArrayList<>();
        Mago mago = new Mago("Harry Potter", 100, hechizos);
        hechizos.add(new Hechizo("bola de fuego", 20, 7));
        hechizos.add(new Hechizo("escudo mágico", 15, 5));
        hechizos.add(new Hechizo("rayo eléctrico", 25, 9));

        Prueba prueba1 = new Prueba("romper muro", 5, 10);
        Prueba prueba2 = new Prueba("derrotar orco", 8, 15);
        Prueba prueba3 = new Prueba("derrotar elfo oscuro", 10, 20);

        mago.lanzarHechizo("bola de fuego", prueba1);
        System.out.println(prueba1.resolver(mago.getHechizos()));
    }
}
