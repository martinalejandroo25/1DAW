package tema5.academiaMagia;

import java.util.Objects;

public class Hechizo {

    private String nombre;
    private Integer energia; //Energía que debe tener el mago para lanzarlo
    private Integer potencia; //El daño que hace para superar una prueba

    public Hechizo(String nombre, Integer potencia, Integer energia) {
        this.nombre = nombre;
        this.potencia = potencia;
        this.energia = energia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEnergia() {
        return energia;
    }

    public void setEnergia(Integer energia) {
        this.energia = energia;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Hechizo{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", energia=").append(energia);
        sb.append(", potencia=").append(potencia);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Hechizo hechizo = (Hechizo) o;
        return Objects.equals(nombre, hechizo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }


    /**
     * Devuelve true si la potencia del hechizo es mayor o igual que la dificultad
     * de la prueba. False en caso contrario.
     * @param prueba
     * @return
     */
    public boolean esEfectivo(Prueba prueba) {
        if (this.getPotencia() >= prueba.getNivelDificultad())
            return true;
        else
            return false;

        //return prueba.resolver(this);
    }
}