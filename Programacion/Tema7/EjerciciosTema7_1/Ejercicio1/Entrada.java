package Programacion.Tema7.EjerciciosTema7_1.Ejercicio1;

import java.util.Comparator;
import java.util.Objects;

public class Entrada implements Comparable<Entrada> {
    public String palabra;
    public String word;

    public Entrada(String palabra, String word) {
        this.palabra = palabra;
        this.word = word;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Entrada{");
        sb.append("palabra='").append(palabra).append('\'');
        sb.append(", word='").append(word).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Entrada o1) {
        return this.palabra.compareToIgnoreCase(o1.palabra);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Entrada entrada = (Entrada) o;
        return Objects.equals(palabra, entrada.palabra);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(palabra);
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
