package Programacion.Tema5.Torneos;

public class EquipoFPS extends Equipo {
    private int punteria;

    //Constructor que crea nuevo equipo FPS con su nombre, nivel y punteria

    public EquipoFPS(String nombre, int nivel, int punteria) {
        super(nombre, nivel);
        this.punteria = punteria;
    }

    public int getPunteria() {
        return punteria;
    }

    public void setPunteria(int punteria) {
        this.punteria = punteria;
    }

    //Calcula los puntos del equipo FPS según su nivel y punteria
    @Override
    public int calcularPuntos() {
        return getNivel() + (getPunteria() * 5);
    }
}
