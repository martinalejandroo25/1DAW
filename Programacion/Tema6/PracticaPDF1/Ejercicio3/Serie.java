package Programacion.Tema6.PracticaPDF1.Ejercicio3;

public class Serie  implements Entregable{
    private String titulo;
    private int temporadas;
    private String genero;
    private String creador;
    private boolean prestado;

    public Serie(String titulo, String genero, String creador) {
        this.titulo = titulo;
        this.genero = genero;
        this.creador = creador;
        this.temporadas = 3;
        this.prestado = false;
    }

    public Serie(String titulo, int temporadas, String genero, String creador) {
        this.titulo = titulo;
        this.temporadas = temporadas;
        this.genero = genero;
        this.creador = creador;
        this.prestado = false;
    }

    public Serie() {
    }

    public Serie(String titulo, String creador) {
        this.titulo = titulo;
        this.creador = creador;
        this.genero = "";
        this.temporadas = 3;
        this.prestado = false;
    }
    public Serie (Serie serie){
        this.titulo = serie.titulo;
        this.creador = serie.creador;
        this.genero = serie.genero;
        this.temporadas = serie.temporadas;
        this.prestado = serie.prestado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Serie{");
        sb.append("titulo='").append(titulo).append('\'');
        sb.append(", temporadas=").append(temporadas);
        sb.append(", genero='").append(genero).append('\'');
        sb.append(", creador='").append(creador).append('\'');
        sb.append(", prestado=").append(prestado);
        sb.append('}');
        System.out.println();
        return sb.toString();
    }

    @Override
    public void entregar() {
        prestado = true;
    }

    @Override
    public void devolver() {
    prestado = false;
    }

    @Override
    public boolean isPrestado() {
        return prestado;
    }
}
