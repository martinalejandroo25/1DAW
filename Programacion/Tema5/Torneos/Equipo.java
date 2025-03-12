package Programacion.Tema5.Torneos;

import java.util.ArrayList;

public abstract class Equipo {
    private String nombre;
    private int nivel;

    public Equipo(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public abstract int calcularPuntos();

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(nombre).append('\'');
        sb.append(" (nivel: ").append(nivel);
        sb.append(')');
        sb.append(" - Puntos: ").append(calcularPuntos());
        return sb.toString();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
