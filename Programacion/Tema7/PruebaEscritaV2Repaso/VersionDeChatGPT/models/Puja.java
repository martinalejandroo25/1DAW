package Programacion.Tema7.PruebaEscritaV2Repaso.VersionDeChatGPT.models;// Puja.java
import java.time.LocalDateTime;
import java.util.Objects;

public class Puja {
    private String cliente;
    private double puja;
    private LocalDateTime fechaPuja;

    public Puja(String cliente, double puja, LocalDateTime fechaPuja) {
        this.cliente = cliente;
        this.puja = puja;
        this.fechaPuja = fechaPuja;
    }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public double getPuja() { return puja; }
    public void setPuja(double puja) { this.puja = puja; }
    public LocalDateTime getFechaPuja() { return fechaPuja; }
    public void setFechaPuja(LocalDateTime fechaPuja) { this.fechaPuja = fechaPuja; }

    @Override
    public String toString() {
        return "Puja{" +
                "cliente='" + cliente + '\'' +
                ", puja=" + puja +
                ", fechaPuja=" + fechaPuja +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Puja)) return false;
        Puja puja1 = (Puja) o;
        return Double.compare(puja1.puja, puja) == 0 &&
                Objects.equals(cliente, puja1.cliente) &&
                Objects.equals(fechaPuja, puja1.fechaPuja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente, puja, fechaPuja);
    }
}
