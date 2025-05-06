package Programacion.Tema6.PracticaPDF1.Ejercicio5;

public class Libro extends Publicacion implements Prestable {
    private boolean prestado;

    public Libro(String isbn, String titulo, Integer anio, Integer paginas, boolean prestado) {
        super(isbn, titulo, anio, paginas);
        this.prestado = prestado;
    }

    @Override
    public boolean estaPrestado() {
        return prestado;
    }

    @Override
    public void presta() {
        this.prestado = true;
    }

    @Override
    public void devuelve() {
        this.prestado = false;
    }
}
