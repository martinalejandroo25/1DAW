package Programacion.Tema5.BladeOfDarkness;

public class Arma {
    private String nombre;
    private enum tipo {ESPADA, HACHA, BASTON, ARCO}
    private int puntosD;
    private boolean dosManos;

    public Arma(String nombre, int puntosD, boolean dosManos) {
        this.nombre = nombre;
        this.puntosD = puntosD;
        this.dosManos = dosManos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntosD() {
        return puntosD;
    }

    public void setPuntosD(int puntosD) {
        this.puntosD = puntosD;
    }

    public boolean isDosManos() {
        return dosManos;
    }

    public void setDosManos(boolean dosManos) {
        this.dosManos = dosManos;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Arma{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", puntosD=").append(puntosD);
        sb.append(", dosManos=").append(dosManos);
        sb.append('}');
        return sb.toString();
    }
}
