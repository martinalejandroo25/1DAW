package Programacion.Tema7.RelacionPDF.Ejercicio1;

import java.util.ArrayList;
import java.util.Objects;

public class Pelicula {
    private static int idConta = 0;
    private int id;
    private String titulo;
    private int year;
    ArrayList<Genero> generos;
    ArrayList<Director> directores;

    public Pelicula(int id, String titulo, int year, ArrayList<Genero> generos, ArrayList<Director> directores) {
        this.id = id;
        this.titulo = titulo;
        this.year = year;
        this.generos = new ArrayList<>();
        this.directores = directores;
    }

    public void addGenero(Genero genero){
        this.generos.add(genero);
    }
    public void addDirectores(Director director){
        this.directores.add(director);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pelicula{");
        sb.append("id=").append(id);
        sb.append(", titulo='").append(titulo).append('\'');
        sb.append(", year=").append(year);
        sb.append(", generos=").append(generos);
        sb.append(", directores=").append(directores);
        sb.append('}');
        return sb.toString();
    }


    public ArrayList<Director> getDirectores() {
        return directores;
    }

    public void setDirectores(ArrayList<Director> directores) {
        this.directores = directores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return id == pelicula.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public static int getIdConta() {
        return idConta;
    }

    public static void setIdConta(int idConta) {
        Pelicula.idConta = idConta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(ArrayList<Genero> generos) {
        this.generos = generos;
    }
}
