package Programacion.Tema6.PracticaPDF1.Ejercicio3;

public class Videojuego implements Entregable{
    private String titulo;
    private int horasEstimadas;
    private String genero;
    private String desarrollador;
    private boolean prestado;

    public Videojuego(String titulo, String genero, String desarrollador) {
        this.titulo = titulo;
        this.horasEstimadas = 100;
        this.genero = genero;
        this.desarrollador = desarrollador;
        this.prestado = false;
    }

    public Videojuego() {
    }

    public Videojuego(String titulo, int horasEstimadas) {
        this.titulo = titulo;
        this.horasEstimadas = horasEstimadas;
    }

    public Videojuego(String titulo, int horasEstimadas, String genero, String desarrollador) {
        this.titulo = titulo;
        this.horasEstimadas = horasEstimadas;
        this.genero = genero;
        this.desarrollador = desarrollador;
    }
    public Videojuego(Videojuego videojuego) {
        this.titulo = videojuego.titulo;
        this.horasEstimadas = videojuego.horasEstimadas;
        this.genero = videojuego.genero;
        this.desarrollador = videojuego.desarrollador;
        this.prestado = videojuego.prestado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getHorasEstimadas() {
        return horasEstimadas;
    }

    public void setHorasEstimadas(int horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Videojuego{");
        sb.append("titulo='").append(titulo).append('\'');
        sb.append(", horasEstimadas=").append(horasEstimadas);
        sb.append(", genero='").append(genero).append('\'');
        sb.append(", desarrollador='").append(desarrollador).append('\'');
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
