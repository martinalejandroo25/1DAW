package Programacion.Examen2Evaluacion.AlquilerCoches.src;

import java.util.Objects;
import java.util.UUID;

public abstract class Persona {
    //ATRIBUTOS
    private String id;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String direccion;
    private String telefono;

    //CONSTRUCTORES

    //Constructor vacío
    public Persona() {
    }

    //Constructor con todos los parámetros
    public Persona(String nombre, String apellido, String dni, String email, String direccion, String telefono) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
    }


    //GETTERS Y SETTERS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    //METODOS

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persona{");
        sb.append("id='").append(id).append('\'');
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append(", dni='").append(dni).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", direccion='").append(direccion).append('\'');
        sb.append(", telefono='").append(telefono).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(id, persona.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
