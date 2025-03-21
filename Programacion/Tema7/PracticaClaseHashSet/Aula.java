package Programacion.Tema7.PracticaClaseHashSet;

import java.util.ArrayList;

public class Aula {
    //2. Crea una clase Aula que tenga un ArrayList<Alumno>, con una propiedad nombre y
    //otra ubicación, ambas String. Un constructor con ambas propiedades y que inicialice
    //el ArrayList. Getters, setters, toString, addAlumno, removeAlumno, listarTodos
    private String nombre;
    private String ubicacion;
    ArrayList<Alumno> alumnos;
    public Aula(ArrayList<Alumno> alumnos, String nombre, String ubicacion) {
        this.alumnos = new ArrayList<>();
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public void addAlumno(Alumno al){
        alumnos.add(al);
    }
    public void removeAlumno(Alumno al){
        alumnos.remove(al);
    }
    public void listarAlumnos(){
        for (Alumno al : alumnos){
            System.out.println(al.getDni() +" : " + al.getNombre() + " " + al.getApellidos());
        }
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

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
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
