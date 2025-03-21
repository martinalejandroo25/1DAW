package Programacion.Tema7;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
         //3. En un main crea un objeto Aula y añade 5 alumnos diferentes.
    ArrayList<Alumno> alumnos = new ArrayList<>();
    HashSet<Alumno> alumnosSet = new HashSet<>();
    Aula aula = new Aula(alumnos, "Informatica", "Sala de Ordenadores II");
    AulaNueva aulaNueva = new AulaNueva("Telecomunicaciones", "Sala de Telecomunicaciones", alumnosSet);

    Alumno a1 = new Alumno("1111111", "al1", "apel1", "alumno12gmail.com", 14, "Almeria Capital");
    Alumno a2 = new Alumno("1111112", "al2", "apel1", "alumno12gmail.com", 14, "Almeria Capital");
    Alumno a3 = new Alumno("1111113", "al3", "apel1", "alumno12gmail.com", 14, "Almeria Capital");
    Alumno a4 = new Alumno("1111114", "al4", "apel1", "alumno12gmail.com", 14, "Almeria Capital");
    Alumno a5 = new Alumno("1111115", "al5", "apel1", "alumno12gmail.com", 14, "Almeria Capital");

    //4. Luego añade un alumno repetido y comprueba que aparece repetido.
    Alumno a6 = new Alumno("1111115", "al6", "apel6", "alumno12gmail.com", 14, "Almeria Capital");
    aula.addAlumno(a1);
    aula.addAlumno(a2);
    aula.addAlumno(a3);
    aula.addAlumno(a4);
    aula.addAlumno(a5);
    aula.addAlumno(a6);

    aulaNueva.addAlumno(a1);
    aulaNueva.addAlumno(a2);
    aulaNueva.addAlumno(a3);
    aulaNueva.addAlumno(a4);
    aulaNueva.addAlumno(a5);
    aulaNueva.addAlumno(a6);

    //6. ¿Muestra en el mismo orden listarTodos en Aula que en AulaNueva? ¿Por qué?
        aula.listarAlumnos();
        System.out.println("---------------------------");
        aulaNueva.listarAlumnos();


    }
}
