package Programacion.Tema7;

import java.util.Objects;

public class Alumno {
    /*1. Crea una clase Alumno con las siguientes propiedades: dni, nombre, apellidos,
email, edad, ciudad. Constructor, getters, setters, toString. EQUALS POR DNI




4. Luego añade un alumno repetido y comprueba que aparece repetido.

5. Implementa la clase AulaNueva con un HashSet<Alumno> y comprueba que el repetido no
se añade.

6. ¿Muestra en el mismo orden listarTodos en Aula que en AulaNueva? ¿Por qué?

7. ¿Hay una manera de quitar repetidos de un ArrayList de forma fácil?*/
    private String dni;
    private String nombre;
    private String apellidos;
    private String email;
    private int edad;
    private String ciudad;

    public Alumno(String dni, String nombre, String apellidos, String email, int edad, String ciudad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno that = (Alumno) o;
        return Objects.equals(dni, that.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dni);
    }
}
