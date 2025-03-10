package Programacion.Tema5.Torneos;

public class EquipoFPS extends Equipo{
    private int punteria;

    //Constructor con Super
    public EquipoFPS(String nombre, int nivel, int punteria) {
        super(nombre, nivel);
        this.punteria = punteria;
    }

    //Calcula los puntos en función del nivel y puntería
    @Override
    public int calcularPuntos() {
        return nivel + (punteria * 5);
    }
}
