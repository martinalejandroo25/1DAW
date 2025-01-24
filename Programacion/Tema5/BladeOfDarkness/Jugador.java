package Programacion.Tema5.BladeOfDarkness;

public class Jugador {
    private String nombre;
    private enum clase{MAGO, BRUJO, BARBARO, CABALLERO}
    private int nivel;
    private int experiencia;
    private double salud;
    private Arma armaDerecha;
    private Arma armaIzquierda;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.nivel = 1;
        this.salud=200;
        this.experiencia=0;
        this.armaDerecha=null;
        this.armaIzquierda=null;
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

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public double getSalud() {
        return salud;
    }

    public void setSalud(double salud) {
        this.salud = salud;
    }

    public Arma getArmaDerecha() {
        return armaDerecha;
    }

    public void setArmaDerecha(Arma armaDerecha) {
        this.armaDerecha = armaDerecha;
    }

    public Arma getArmaIzquierda() {
        return armaIzquierda;
    }

    public void setArmaIzquierda(Arma armaIzquierda) {
        this.armaIzquierda = armaIzquierda;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", experiencia=" + experiencia +
                ", salud=" + salud +
                ", armaDerecha=" + armaDerecha +
                ", armaIzquierda=" + armaIzquierda +
                '}';
    }

    public void subirNivel(){
        if (nivel <10) {
            nivel++;
            salud= Math.pow(2.5, nivel);
        }
        else System.out.println("Nivel máximo alcanzado");
    }

    public boolean equiparArma(Arma arma){
        if (armaDerecha==null){
            armaDerecha=arma;
            return true;
        } else if (armaIzquierda==null) {
            armaIzquierda=arma;
            return true;
        } else if (arma.isDosManos() && armaIzquierda==null && armaDerecha==null) {
            armaIzquierda=arma;
            armaDerecha=arma;
            return true;
        } else {
            System.out.println("Ya estas cargado, no puedes llevar más armas");
             return false;
            }
        }

        public void tomarPocion(int puntosS){
            salud+=puntosS;
            if (salud>10000){
                salud=10000;
            }
        }

        public boolean reducirVida(int puntosD){
        salud-=puntosD;
            if (salud<=0){
                salud=0;
                System.out.println("Game Over, Has muerto, pero no pierdas tu determinación");
                return true;
            } else {
                return false;
            }
        }

        public void golpear(Monstruo monstruo) {

        if (this.getArmaDerecha() != null) {
            monstruo.reducirVida(this.getArmaDerecha().getPuntosD());
        }
        }
}
