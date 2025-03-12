package Programacion.Tema5.Torneos;

import java.util.ArrayList;

public class Torneo {
    private String nombre;
    private ArrayList<Equipo> equipos = new ArrayList<>();

    public Torneo(String nombre, ArrayList<Equipo> equipos) {
        this.nombre = nombre;
        this.equipos = equipos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public void inscribirEquipo(Equipo equipo) {
        equipos.add(equipo);
    }
    public Equipo jugarTorneo() {
        int maxPuntaje = 0;
        Equipo ganador = null;
        for (Equipo equipo : equipos) {
            int puntaje = equipo.calcularPuntos();
            if (puntaje > maxPuntaje) {
                maxPuntaje = puntaje;
                ganador = equipo;
            }
        }
        return ganador;
    }
    public void imprimirEquipo(){
        System.out.println("-------Equipos Inscritos--------");
        for (Equipo equipo : equipos) {
            System.out.println(equipo.getNombre()+ " Puntos: "+ equipo.calcularPuntos()  );
        }
    }
}
