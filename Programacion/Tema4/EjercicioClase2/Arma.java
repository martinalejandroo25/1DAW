package Programacion.Tema4.EjercicioClase2;

public class Arma {
    private String nombre;

    public Arma(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Arma{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    public enum TipoArma {ESPADA, MARTTILLO, HACHA}
}
