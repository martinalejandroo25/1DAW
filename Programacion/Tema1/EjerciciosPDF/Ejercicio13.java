package Programacion.Tema1.EjerciciosPDF;

public class Ejercicio13 {
    public static void main(String[] args) {
        //Realiza un programa en Java con una variable entera t la cual contiene un tiempo en segundos y queremos conocer este tiempo, pero expresados en horas, minutos y segundos.

        int t = 12000;
        int horas = t/3600;
        int minutos = t/60;
        int segundos = t%3600;
        System.out.println(t+" segundos  "+ "son "+ horas+" horas"+ minutos+" minutos"+ segundos+" segundos");
    }
}
