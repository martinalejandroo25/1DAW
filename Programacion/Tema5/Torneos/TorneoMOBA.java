package Programacion.Tema5.Torneos;

import java.util.ArrayList;

public class TorneoMOBA extends Torneo {

    public TorneoMOBA(String nombre, ArrayList<Equipo> equipos) {
        super(nombre, equipos);
    }
    //solo se pueden inscribir equipos del tipo EquipoMOBA
    @Override
    public void inscribirEquipo(Equipo equipo) {
        if (equipo instanceof EquipoMOBA) {
            super.inscribirEquipo(equipo);
        } else {
            throw new EquipoNoValidoException("El equipo NO es de tipo EquipoMOBA");
        }
    }

}
