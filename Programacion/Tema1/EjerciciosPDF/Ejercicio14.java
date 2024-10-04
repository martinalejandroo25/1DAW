package Programacion.Tema1.EjerciciosPDF;

public class Ejercicio14 {
    public static void main(String[] args) {
        //Realiza un programa en Java que genere números de forma aleatoria simulando la tirada de un dado
        int dado = (int) (Math.random() * 6) + 1;
        System.out.println("El dado ha caido en el número: "+dado);
    }
}
