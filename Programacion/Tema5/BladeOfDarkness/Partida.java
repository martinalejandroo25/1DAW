package Programacion.Tema5.BladeOfDarkness;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Partida {
    private Jugador jugador;
    private ArrayList<Monstruo> monstruos;

    public Partida(Jugador jugador, ArrayList<Monstruo> monstruos) {
        this.jugador = jugador;
        this.monstruos = monstruos;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void iniciarPartida() {

        int conta = 0;
        while(conta < 100) {
            for (Monstruo monstruo : monstruos) {
                monstruos.add(monstruo);
                conta++;
            }
        }
    }
    public void turnoJugador() {

    }
}
