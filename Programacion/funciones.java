package Programacion;

public class funciones {

    /**
     * GENERA UN NUMERO ALEATORIO CON MATH.RANDOM
     * @param menor
     * @param mayor
     * @return
     */
    public static int generarnumAleatorio(int menor, int mayor) {
        return (int) (Math.random() * (mayor - menor + 1) + menor);

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
        double total = 0;
        for (int i = 0; i < numeros.length; i++) {
            total += numeros[i];
        }
        return total;
    }

    public static boolean multiplo (int a, int b){
        return a % b == 0;
    }

    public static boolean esPrimos(int num){
        boolean esPrimo = true;
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                esPrimo = false;
                break;
            }
        }
        return esPrimo;
    }
}
