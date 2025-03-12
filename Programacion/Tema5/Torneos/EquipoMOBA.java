package Programacion.Tema5.Torneos;

public class EquipoMOBA extends Equipo {
    private int estrategia;

    //Constructor que crea nuevo equipo MOBA con su nombre, nivel y estrategia
    public EquipoMOBA(String nombre, int nivel, int estrategia) {
        super(nombre, nivel);
        this.estrategia = estrategia;
    }

//GETTERS Y SETTERS
    public int getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(int estrategia) {
        this.estrategia = estrategia;
    }

    //Calcula los puntos del equipo MOBA según su nivel y estrategia
    @Override
    public int calcularPuntos() {
        return getNivel() * getEstrategia();
    }

}
