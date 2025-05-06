package Programacion.Tema7.RepasoColecciones.Ejercicio1;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
            Baraja baraja = new Baraja();

        for (int i = 0; i < 10; i++) {
            baraja.baraja.add(new Carta(i+1, "Corazones"));

        }
        for (int i = 0; i < 10; i++) {
            baraja.baraja.add(new Carta(i+1, "diamantes"));
        }
        for (int i = 0; i < 10; i++) {
            baraja.baraja.add(new Carta(i+1, "treboles"));
        }
        for (int i = 0; i < 10; i++) {
            baraja.baraja.add(new Carta(i+1, "picas"));
        }

        Collections.shuffle(baraja.baraja);
        System.out.println(baraja.baraja);
        Collections.sort(baraja.baraja);
        System.out.println(baraja.baraja);


    }
}
