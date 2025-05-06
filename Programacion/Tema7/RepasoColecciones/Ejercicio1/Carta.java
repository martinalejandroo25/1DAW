package Programacion.Tema7.RepasoColecciones.Ejercicio1;

public class Carta implements Comparable<Carta> {
    private Integer numero;
    private String palo;

    public Carta(Integer numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Carta --> ");
        sb.append(numero);
        sb.append(", palo --> ").append(palo).append('\n');
        return sb.toString();
    }

    @Override
    public int compareTo(Carta o) {
        if (this.palo.equals(o.palo)) {
            return this.numero.compareTo(o.numero);
        }
        return this.palo.compareTo(o.palo);
    }
}
