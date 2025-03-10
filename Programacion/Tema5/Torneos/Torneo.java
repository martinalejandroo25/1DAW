package Programacion.Tema5.Torneos;

import java.util.ArrayList;

public class Torneo {
    private String nombre;
    private ArrayList<Equipo> equipos;

    public Torneo(String nombre, ArrayList<Equipo> equipos) {
        this.nombre = nombre;
        this.equipos = equipos;
    }


    public void inscribirEquipo(Equipo equipo) {
        equipos.add(equipo);
    }
    //que simule el torneo y
    //devuelva el equipo ganador (el que tenga más puntos al calcular
    //calcularPuntos()).
    public Equipo jugarTorneo() {
        /*for (int i = 0; i < equipos.toArray().length; i++) {
            System.out.println(i+"." + equipos.get(i).getNombre() +"("+"Nivel: "+equipos.get(i).getNivel()+", Estrategia: " + equipos.get(i)."" "- Puntos");

        }*/
    }

    public void imprimirEquipo(){
        equipos.forEach(System.out::println);
    }
}
