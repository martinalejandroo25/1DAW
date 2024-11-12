package Programacion.Tema2.bucles.EjerciciosPDF;

public class Ejercicio6 {
    public static void main(String[] args) {
        // Programa que sume los 100 primeros números enteros impares.
        int num = 0;
        System.out.println(sumaImpar(num));


    }
    public static int sumaImpar(int num){
        for (int i = 0; i < 100; i++) {
            if ((i % 2) != 0) {
                num = num + i;
            }
        }
        return num;
    }
}
