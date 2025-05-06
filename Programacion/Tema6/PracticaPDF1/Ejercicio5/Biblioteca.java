package Programacion.Tema6.PracticaPDF1.Ejercicio5;

import java.util.ArrayList;

public class Biblioteca {
    ArrayList<Publicacion> biblioteca;
    private String direccion;

    public Biblioteca(ArrayList<Publicacion> biblioteca, String direccion) {
        this.biblioteca = biblioteca;
        this.direccion = direccion;
    }

    public ArrayList<Publicacion> getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(ArrayList<Publicacion> biblioteca) {
        this.biblioteca = biblioteca;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void adquirirMaterial(Publicacion unaPub) {
        biblioteca.add(unaPub);
    }

    public Publicacion buscar(String titulo) {
        int Publicacion = biblioteca.indexOf(titulo);
        return biblioteca.get(Publicacion);
    }
}
