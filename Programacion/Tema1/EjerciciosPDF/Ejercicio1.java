package Programacion.Tema1.EjerciciosPDF;

public class Ejercicio1 {
    // Si A=6 B=2 C=3, indicar el resultado final de las siguientes expresiones aritméticas
    int a=6;
    int b=2;
    int c=3;

    public static void main(String[] args) {
        double a=6;
        double b=2;
        double c=3;

        System.out.println("apartado A= " + ((a*c)%c));
        System.out.println("apartado B= " + (a*b/c));
        System.out.println("apartado C= " + (c%b + c*b));
        System.out.println("apartado D= " + (a%(a*b*c/(b+c))));
        System.out.println("apartado E= " + (b*b+c-b*(a%b)));
    }
}