package Programacion.Tema5.Torneos;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Equipo equipoFPS1 = new EquipoFPS("Team FPSA", 5, 4);
        Equipo equipoFPS2 = new EquipoFPS("Team FPSB", 6, 8);
        Equipo equipoFPS3 = new EquipoFPS("Team FPSC", 2, 2);

        Equipo equipoMOBA1 = new EquipoMOBA("Team MOBAA", 5, 4);
        Equipo equipoMOBA2 = new EquipoMOBA("Team MOBAB", 6, 8);
        Equipo equipoMOBA3 = new EquipoMOBA("Team MOBAC", 2, 2);


        ArrayList<Equipo> equipoFPS = new ArrayList<>();
        equipoFPS.add(equipoFPS1);
        equipoFPS.add(equipoFPS2);
        equipoFPS.add(equipoFPS3);
        ArrayList<Equipo> equipoMOBA = new ArrayList<>();
        equipoMOBA.add(equipoMOBA1);
        equipoMOBA.add(equipoMOBA2);
        equipoMOBA.add(equipoMOBA3);
        Torneo torneoFPS = new TorneoFPS("Torneo FPS", equipoFPS);
        Torneo torneoMOBA = new TorneoMOBA("Torneo MOBA", equipoMOBA);

        System.out.println("Equipos inscritos en el Torneo FPS");
        torneoFPS.imprimirEquipo();
        System.out.println();
        System.out.println("Ganador del Torneo MOBA: " + torneoMOBA.jugarTorneo());
        System.out.println();
        System.out.println("Equipos inscritos en el Torneo MOBA");
        torneoMOBA.imprimirEquipo();
        System.out.println();
        System.out.println("Ganador del Torneo FPS: " + torneoFPS.jugarTorneo());
        
    }
}
