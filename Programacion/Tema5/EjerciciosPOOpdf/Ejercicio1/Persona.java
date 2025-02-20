package Programacion.Tema5.EjerciciosPOOpdf.Ejercicio1;

public class Persona {
    private String nombre;
    private Integer edad;
    private String dni;
    private String sexo;
    private int peso;
    private int altura;

    //Contructores

    public Persona() {
    }

    public Persona(String nombre, Integer edad, String dni, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.sexo = sexo;
    }

    public  Persona (Persona persona){
        this.nombre = persona.dni;
        this.edad = persona.edad;
        this.dni = persona.dni;
        this.sexo = persona.sexo;
    }

}
