package Programacion.Tema4.EjercicioClase1;

public class Personaje {
    /*1. Crear una clase Personaje
   Propiedades: (private)
   - nombre de tipo String
   - clase de tipo String (elfo, bárbaro, ...)
   - sexo de tipo String (hombre, mujer, nodefinido)
   - vida de tipo Integer (0 - 100)*/
    private String nombre;
    private String clase;
    private String sexo;
    private int vida;

    public Personaje(String nombre, String clase, String sexo, int vida) {
        this.nombre = nombre;
        this.clase = clase;
        this.sexo = sexo;
        this.vida = vida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", clase='" + clase + '\'' +
                ", sexo='" + sexo + '\'' +
                ", vida=" + vida +
                '}';
    }
}
