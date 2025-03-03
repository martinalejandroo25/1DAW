package Programacion.Tema5.EjerciciosPOOpdf.Ejercicio1;

import java.util.Objects;

public class Persona {
    // Miembros: nombre, edad, dni, sexo (‘H’ para hombre, ‘M’ para mujer, ‘O’ para otro), peso y altura.
    private String nombre;
    private int edad;
    private String dni;
    private String sexo;
    private double peso;
    private double altura;

    //Constructores
    //Un constructor por defecto.
    public Persona() {
    }

    //o Un constructor con el nombre, edad, dni, sexo, y el resto por defecto.
    public Persona(String nombre, int edad, String dni, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.sexo = sexo;
        this.peso = 0;
        this.altura = 0;
    }


    //o Un constructor con todos los miembros como parámetro.
    public Persona(String nombre, int edad, String dni, String sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    //o Un constructor copia.
    public Persona(Persona persona) {
        this.nombre = persona.nombre;
        this.edad = persona.edad;
        this.dni = persona.dni;
        this.sexo = persona.sexo;
        this.peso = persona.peso;
        this.altura = persona.altura;
    }
    //Métodos:
    //- calcularIMC(): indicará si la persona está en su peso ideal. Para ello, puedesutilizar la
    //fórmula:
    //peso(en kg) /altura2
    //(en m)
    public int calcularIMC(
    ) {
        double imc = peso / Math.pow(2, altura);
       //Devuelve 1 si está en su peso ideal
        if (imc < 20)
           return 1;
        //Devuelve 0 si está por debajo de su peso ideal
       else if (imc >=20 && imc <=25)
           return 0;
       // Devuelve -1 si tiene sobrepeso
       else return -1;
                
    }
    public boolean esMayorEdad(){
        if (edad >= 18)
                return true;
        else return false;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persona{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", edad=").append(edad);
        sb.append(", dni='").append(dni).append('\'');
        sb.append(", sexo=").append(sexo);
        sb.append(", peso=").append(peso);
        sb.append(", altura=").append(altura);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(dni, persona.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dni);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
