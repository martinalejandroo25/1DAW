package Programacion.Tema3.Array;

public class EjercicioClase2 {

    public static void main(String[] args) {
        /*
        * Genera de forma aleatoria un array de doubles con 30 elementos
        * Los valores estarán entre -100 y 100
        * Pinta los valores
        * Pinta los valores al reves
        * Dime la media de todos los valores
        * */
        double[] numeros = new double[30];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = generarnumAleatorio(-100,100);
        }
        pintarArray(numeros);
        System.out.println();
        System.out.println("Al reves:");
        pintarArrayReves(numeros);
        System.out.println();
        System.out.println("La media:");
        System.out.println(mediaDeArray(numeros));;
    }

    public static int generarnumAleatorio(int menor, int mayor) {
        int numero = (int) (Math.random() * (menor - mayor) + mayor);
        return numero;
    }

    public static void pintarArray(double[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("["+numeros[i]+"], ");
        }
    }
    public static void pintarArrayReves(double[] numeros) {
        for (int i = numeros.length-1; i >= 0; i--) {
            System.out.print("["+numeros[i]+"], ");
        }
    }
    public static double mediaDeArray(double[] numeros) {
        double total=0;
        for (int i = 0; i < numeros.length; i++) {
            total += numeros[i];
        }
        double media = total/numeros.length;
        return media;
    }
}
