package Programacion;

public class funciones {

    /**
     * GENERA UN NUMERO ALEATORIO CON MATH.RANDOM
     * @param menor
     * @param mayor
     * @return
     */
    public static int generarnumAleatorio(int menor, int mayor) {
        int numero = (int) (Math.random() * (menor - mayor) + mayor);
        return numero;
    }

    public static boolean multiplo (int a, int b){
        return a % b == 0;
    }
}
