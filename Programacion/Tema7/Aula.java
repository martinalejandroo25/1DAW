package Programacion.Tema7;

import com.sun.source.doctree.SeeTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Aula {
    //2. Crea una clase Aula que tenga un ArrayList<Alumno>, con una propiedad nombre y
    //otra ubicación, ambas String. Un constructor con ambas propiedades y que inicialice
    //el ArrayList. Getters, setters, toString, addAlumno, removeAlumno, listarTodos
    private String nombre;
    private String ubicacion;
    HashSet<Alumno> alumnos;
    public Aula(ArrayList<Alumno> alumnos, String nombre, String ubicacion) {
        this.alumnos = new HashSet<>();
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public void addAlumno(Alumno al){
        alumnos.add(al);
    }
    public void removeAlumno(Alumno al){
        alumnos.remove(al);
    }
    public void listarTodos(){
        System.out.println(alumnos.toString());
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Aula{");
        sb.append("alumnos=").append(alumnos);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", ubicacion='").append(ubicacion).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public HashSet<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(HashSet<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
