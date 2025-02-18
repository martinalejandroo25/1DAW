package Programacion.Tema5.BladeOfDarkness;

public class Monstruo extends Personaje  {
    enum clase{GOBLIN, TROLL, SKRALL, DEMONIO, FANTASMA}
    private int puntosD;

    public Monstruo(String nombre, int nivel, double salud, int puntosD) {
        super(nombre, nivel, salud);
        this.puntosD = puntosD;
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
        sb.append("puntosD=").append(puntosD);
        sb.append('}');
        return sb.toString();
    }

    public void golpear(Jugador jugador) throws Exception {
        if (getSalud() > 0) {
            jugador.reducirVida(getPuntosD());
        } else throw new Exception("Monstruo derrotado no puede atacar");
    }

    

}
