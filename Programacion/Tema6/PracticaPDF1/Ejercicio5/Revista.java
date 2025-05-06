package Programacion.Tema6.PracticaPDF1.Ejercicio5;

public class Revista extends Publicacion{
    private Integer numero;

    public Revista(String isbn, String titulo, Integer anio, Integer paginas, Integer numero) {
        super(isbn, titulo, anio, paginas);
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
