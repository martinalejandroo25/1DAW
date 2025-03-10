package Programacion.Tema5.Torneos;

public abstract class Equipo {
    protected String nombre;
    protected int nivel;

    public Equipo(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }
    public abstract int calcularPuntos();

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Equipo{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", nivel=").append(nivel);
        sb.append('}');
        return sb.toString();
    }
}
