package Programacion.Tema7.HobbiesTreeMap;

import java.util.List;
import java.util.TreeMap;

public class Persona implements Comparable<Persona>{
    //Vamos a realizar un ejemplo para guardar los hobbies de personas. Cada persona tendrá un nombre y una edad. La estructura para guardar los hobbies sería un TreeMap<Persona, List<String>>, donde se ordenarías las personas por edad. Añade datos y muéstralos. Añadir métodos addPersona, addHobbie(Persona, String), listarTodos().
    private String nombre;
    private Integer edad;
    TreeMap<Persona, List<String>> hobbies;

    public Persona(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
        hobbies = new TreeMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persona{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", edad=").append(edad);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Persona p) {
        return Integer.compare(this.edad, p.edad);
    }

}
