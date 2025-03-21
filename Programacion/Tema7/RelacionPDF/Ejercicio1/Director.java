package Programacion.Tema7.RelacionPDF.Ejercicio1;

import java.util.ArrayList;
import java.util.Objects;

public class Director {
    private static int idConta = 0;
    private int id;
    private String nombre;
    private ArrayList<Pelicula> peliculas;

    public Director(String nombre, ArrayList<Pelicula> peliculas) {
        this.id = ++idConta;
        this.nombre = nombre;
        this.peliculas = new ArrayList<>();
    }

    public static int getIdConta() {
        return idConta;
    }

    public static void setIdConta(int idConta) {
        Director.idConta = idConta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Director{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", peliculas=").append(peliculas);
        sb.append('}');
        return sb.toString();
    }

    public void addPelicula(Pelicula peli){
        this.peliculas.add(peli);
    }
    public void removePelicula(Pelicula peli){
        this.peliculas.remove(peli);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return id == director.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
