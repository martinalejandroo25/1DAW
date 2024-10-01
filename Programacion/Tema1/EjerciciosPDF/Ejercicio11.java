package Programacion.Tema1.EjerciciosPDF;

public class Ejercicio11 {
    public static void main(String[] args) {
        //Realiza un programa que calcule el área y el perímetro de un círculo de radio 3,6m
        double radio = 3.6;
        double area = Math.PI * radio * radio;
        double perimetro = 2 * Math.PI * radio;

        System.out.println("Radio = " +radio);
        System.out.println("Area = " +area);
        System.out.println("Perimetro = " +perimetro);
    }
}
