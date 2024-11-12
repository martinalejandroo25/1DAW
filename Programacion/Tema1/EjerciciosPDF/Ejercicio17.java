package Programacion.Tema1.EjerciciosPDF;

public class Ejercicio17 {
    /*USO DE MATH.RANDOM()
    * Para un número entre min y max
    * double aleatorioEnRango = min + (Math.random() * (max - min))
    * */
    public static void main(String[] args) {
        //a) crear un número entero positivo aleatorio entre 1 y 49
        int a= (int)(1 + ( Math.random() * (49 - 1)));
        System.out.println(a);

        //b) Generar un número aleatorio positivo par
        int b = 2 * ((int)(Math.random() * 50) + 1);
        System.out.println(b);

        //c) Generar un número real aleatorio entre 1 y 10
        int c = (int)(Math.random() * 10) + 1;
        System.out.println(c);
        //d) Crear un número entero negativo entre -50 y -150
        int d = (int)((-50) + (Math.random() * ((-150) - (-50))));
        System.out.println(d);
    }
}
