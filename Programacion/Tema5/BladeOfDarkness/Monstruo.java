package Programacion.Tema5.BladeOfDarkness;

public class Monstruo {
    private String nombre;
    enum clase{GOBLIN, TROLL, SKRALL, DEMONIO, FANTASMA}
    private int nivel;
    private double salud;
    private int puntosD;

    public Monstruo(String nombre, int puntosD) {
        this.nombre = nombre;
        this.puntosD = puntosD;
        this.nivel = 1;
        this.salud = 100;
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

    public double getSalud() {
        return salud;
    }

    public void setSalud(double salud) {
        this.salud = salud;
    }

    public int getPuntosD() {
        return puntosD;
    }

    public void setPuntosD(int puntosD) {
        this.puntosD = puntosD;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Monstruo{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", nivel=").append(nivel);
        sb.append(", salud=").append(salud);
        sb.append(", puntosD=").append(puntosD);
        sb.append('}');
        return sb.toString();
    }

    public void subirNivel() {
        if (nivel <10) {
            nivel++;
            salud=Math.pow(2, nivel);
        } else System.out.println("Nivel actual "+nivel+", Máximo alcanzado"); //quiero comprobar si llega bien al nivel 10
    }


}
