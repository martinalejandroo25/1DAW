package Programacion.Tema4.EjercicioClase2;

public class TestArma {
    /*1. Crear una nueva clase Arma
    Propiedades:
    - nombre de tipo String
    - tipo de tipo enum TipoArma
    - golpe de tipo Integer

    Para crear un enum -> enum TipoArma { ESPADA, MARTILLO, HACHA }

    Constructor:
    - con todas las propiedades
    - vacío sin valores (que tome los valores por defecto) -> dejar en blanco el constructor

    Métodos:
    - Getter y Setter y toString
    - public void golpear(Personaje personaje) {
        personaje.setVida(personaje.getVida() - this.golpe);
      }

2. Crear una clase TestArma, creando una espada y un martillo
   Crear un personaje como en el ejercicio anterior
   Golpear con la espada a ese personaje
   Pintar la espada, el martillo y el personaje*/

    public static void main(String[] args) {
        Arma espada = new Arma("Espada");
        Arma martillo = new Arma("martillo");
        Personaje per1 = new Personaje("Jugador1", "Vikingo", "Mujer", 150);
    }
}
