package Programacion.Tema1.EjerciciosPDF;

public class Ejercicio10 {
    public static void main(String[] args) {
        int num=5;
        num += num - 1*4+1;
        System.out.println(num);
        num=4;
        num %= 7 * num % 3 * 5;
        System.out.println(num);
        //se mostrará 2 veces la variable num, cuyo valor se ha sobreescrito 4 veces, mostrandose por pantalla 2 de ellas+
        //Es interesante para ver como la programación es lineal y los valores de una variable pueden ir sobreescribiendose y reemplazarse
    }
}
