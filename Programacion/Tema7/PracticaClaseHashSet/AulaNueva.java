package Programacion.Tema7.PracticaClaseHashSet;

import java.util.HashSet;

public class AulaNueva {
    //5. Implementa la clase AulaNueva con un HashSet<Alumno> y comprueba que el repetido no se añade.
    private String nombre;
    private String ubicacion;
    HashSet<Alumno> alumnos;

    public AulaNueva(String nombre, String ubicacion, HashSet<Alumno> alumnos) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.alumnos = new HashSet<>();
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

    public HashSet<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(HashSet<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AulaNueva{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", ubicacion='").append(ubicacion).append('\'');
        sb.append(", alumnos=").append(alumnos);
        sb.append('}');
        return sb.toString();
    }

    public void addAlumno(Alumno alumno){
        this.alumnos.add(alumno);
    }
    public boolean delAlumno(Alumno alumno){
        return this.alumnos.remove(alumno);
    }
    public void listarAlumnos(){
        for (Alumno al : alumnos){
            System.out.println(al.getDni() +" : " + al.getNombre() + " " + al.getApellidos());
        }
    }

}
