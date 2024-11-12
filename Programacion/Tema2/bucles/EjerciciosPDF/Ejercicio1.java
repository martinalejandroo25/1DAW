package Programacion.Tema2.bucles.EjerciciosPDF;

public class Ejercicio1 {
    /*Crea una función (metodo) que reciba como parámetros tres números enteros y devuelva el mayor de
los tres números. Utilizar esa función para el calcular el mayor de cuatro números enteros. Sería así:*/
    public static int mayor(int a, int b, int c) {
        if (a > b && a > c)
            return a;
        else if (b > a && b > c) {
            return b;
        }
        else return c;
    }
    public static void main(String[] args) {
        int num1 = 3,num2 = 4 ,num3 = 7;
        System.out.println(mayor(num2,num3,num1));
    }
}
