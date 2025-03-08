package Programacion.Tema5.EjerciciosPOOpdf.Ejercicio3;

import java.util.Objects;

public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private Integer numPag;
    private double precioCompra;
    private double precioVenta;
    private boolean vendido;

    // CONSTRUCTORES


    public Libro(String ISBN, String titulo, String autor, Integer numPag, boolean vendido) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.numPag = numPag;
        this.vendido = vendido;
        this.precioVenta = 0;
        this.precioCompra = 0;
    }


    @Override
    public String toString() {
        //metodo toString() para mostrar la información relativa al libro, con el siguiente formato: “El libro W con ISBN X creado por el autor Y tiene Z páginas”. Implementa también el metodo equals.
        final StringBuilder sb = new StringBuilder("el Libro ").append(titulo).append('\'');
        sb.append(" con ISBN '").append(ISBN).append('\'');
        sb.append(" creado por el autor '").append(autor).append('\'');
        sb.append(" tiene ").append(numPag).append(" páginas");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Double.compare(precioCompra, libro.precioCompra) == 0 && Double.compare(precioVenta, libro.precioVenta) == 0 && vendido == libro.vendido && Objects.equals(ISBN, libro.ISBN) && Objects.equals(titulo, libro.titulo) && Objects.equals(autor, libro.autor) && Objects.equals(numPag, libro.numPag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN, titulo, autor, numPag, precioCompra, precioVenta, vendido);
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getNumPag() {
        return numPag;
    }

    public void setNumPag(Integer numPag) {
        this.numPag = numPag;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }
}
