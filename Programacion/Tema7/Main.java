package Programacion.Tema7;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    //3. En un main crea un objeto Aula y añade 5 alumnos diferentes.
    ArrayList<Alumno> alumnos = new ArrayList<>();
    Aula aula = new Aula(alumnos, "Informatica", "Sala de Ordenadores II");

    Alumno a1 = new Alumno("1111111", "al1", "apel1", "alumno12gmail.com", 14, "Almeria Capital");
    Alumno a2 = new Alumno("1111112", "al2", "apel1", "alumno12gmail.com", 14, "Almeria Capital");
    Alumno a3 = new Alumno("1111113", "al3", "apel1", "alumno12gmail.com", 14, "Almeria Capital");
    Alumno a4 = new Alumno("1111114", "al4", "apel1", "alumno12gmail.com", 14, "Almeria Capital");
    Alumno a5 = new Alumno("1111115", "al5", "apel1", "alumno12gmail.com", 14, "Almeria Capital");
}
