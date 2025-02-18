package Programacion.Tema5.BladeOfDarkness;

public abstract class Personaje {
    private String nombre;
    private int nivel;
    private double salud;

    public Personaje(String nombre, int nivel, double salud) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.salud = salud;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Personaje{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", nivel=").append(nivel);
        sb.append(", salud=").append(salud);
        sb.append('}');
        return sb.toString();
    }

    public boolean reducirVida(int puntosD){
        salud-=puntosD;
        if (salud<=0){
            salud=0;
            System.out.println("personaje fallecido");
            return true;
        } else {
            return false;
        }
    }
    public void subirNivel(){
        if (nivel <10) {
            nivel++;
            salud= Math.pow(2.5, nivel);
        }
        else System.out.println("Nivel máximo alcanzado");
    }

}
