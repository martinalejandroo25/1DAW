package Programacion.Tema7.EjerciciosStreams.Canciones;

public class Cancion {
    private String titulo;
    private Artista artista;
    private Integer lanzamientoYear;
    private Integer duracionSegs;
    private double popularidad;
    private Genero genero;

    public Cancion(String titulo, Artista artista, Integer lanzamientoYear, Integer duracionSegs, double popularidad, Genero genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.lanzamientoYear = lanzamientoYear;
        this.duracionSegs = duracionSegs;
        this.popularidad = popularidad;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Integer getLanzamientoYear() {
        return lanzamientoYear;
    }

    public void setLanzamientoYear(Integer lanzamientoYear) {
        this.lanzamientoYear = lanzamientoYear;
    }

    public Integer getDuracionSegs() {
        return duracionSegs;
    }

    public void setDuracionSegs(Integer duracionSegs) {
        this.duracionSegs = duracionSegs;
    }

    public double getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(double popularidad) {
        this.popularidad = popularidad;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cancion{");
        sb.append("titulo='").append(titulo).append('\'');
        sb.append(", artista=").append(artista);
        sb.append(", lanzamientoYear=").append(lanzamientoYear);
        sb.append(", duracionSegs=").append(duracionSegs);
        sb.append(", popularidad=").append(popularidad);
        sb.append('}');
        return sb.toString();
    }
}
