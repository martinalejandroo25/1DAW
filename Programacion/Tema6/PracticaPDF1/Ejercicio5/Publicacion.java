package Programacion.Tema6.PracticaPDF1.Ejercicio5;

import java.util.Objects;

public class Publicacion {
    private String isbn;
    private String titulo;
    private Integer anio;
    private Integer paginas;

    public Publicacion(String isbn, String titulo, Integer anio, Integer paginas) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anio = anio;
        this.paginas = paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Publicacion{");
        sb.append("isbn='").append(isbn).append('\'');
        sb.append(", titulo='").append(titulo).append('\'');
        sb.append(", anio=").append(anio);
        sb.append(", paginas=").append(paginas);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Publicacion that = (Publicacion) o;
        return Objects.equals(titulo, that.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(titulo);
    }
}
