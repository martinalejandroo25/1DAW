package Programacion.Tema5.AcademiaDeMagia;

public class Hechizo {
    private String nombre;
    private int energiaHechizo;
    private int potencia;

    public Hechizo(String nombre, int energiaHechizo, int potencia) {
        this.nombre = nombre;
        this.energiaHechizo = energiaHechizo;
        this.potencia = potencia;
    }

    public void esEfectivo(Prueba prueba) {
        //Volver a terminar más tarde
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hechizo{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", energiaHechizo=").append(energiaHechizo);
        sb.append(", potencia=").append(potencia);
        sb.append('}');
        return sb.toString();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEnergiaHechizo() {
        return energiaHechizo;
    }

    public void setEnergiaHechizo(int energiaHechizo) {
        this.energiaHechizo = energiaHechizo;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
}
