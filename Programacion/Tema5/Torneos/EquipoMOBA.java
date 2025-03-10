package Programacion.Tema5.Torneos;

public class EquipoMOBA extends Equipo {
    private int estrategia;

    //COnstructor con super
    public EquipoMOBA(String nombre, int nivel, int estrategia) {
        super(nombre, nivel);
        this.estrategia = estrategia;
    }

    public int getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(int estrategia) {
        this.estrategia = estrategia;
    }

    //Calcula los puntos en función del nivel y la estrategia
    @Override
    public int calcularPuntos() {
        return nivel * estrategia;
    }
}
