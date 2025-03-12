package Programacion.Tema5.Torneos;

import java.util.ArrayList;

public class TorneoFPS extends Torneo{

    public TorneoFPS(String nombre, ArrayList<Equipo> equipos) {
        super(nombre, equipos);
    }

    //solo se pueden inscribir equipos del tipo EquipoMOBA
    @Override
    public void inscribirEquipo(Equipo equipo) {
        if (equipo instanceof EquipoFPS) {
            super.inscribirEquipo(equipo);
        } else {
            throw new EquipoNoValidoException("El equipo NO es de tipo EquipoFPS");
        }
    }
}
