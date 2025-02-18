package tema5.academiaMagia;

public class Prueba {

    private String descripcion;
    private Integer nivelDificultad; //Nivel que tiene que tener un hechizo para superar la prueba
    private Integer recompensa; //Si supero la prueba la energía que le daríamos al mago

    public Prueba(String descripcion, Integer recompensa, Integer nivelDificultad) {
        this.descripcion = descripcion;
        this.recompensa = recompensa;
        this.nivelDificultad = nivelDificultad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNivelDificultad() {
        return nivelDificultad;
    }

    public void setNivelDificultad(Integer nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }

    public Integer getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(Integer recompensa) {
        this.recompensa = recompensa;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Prueba{");
        sb.append("descripcion='").append(descripcion).append('\'');
        sb.append(", nivelDificultad=").append(nivelDificultad);
        sb.append(", recompensa=").append(recompensa);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Devuelve true si la potencia del hechizo es mayor o igual que
     * el nivel de dificultad de la prueba. False en caso contrario
     * @param hechizo
     * @return
     */
    public boolean resolver(Hechizo hechizo) {
        if (hechizo.getPotencia() >= this.getNivelDificultad())
            return true;
        else
            return false;
    }
}