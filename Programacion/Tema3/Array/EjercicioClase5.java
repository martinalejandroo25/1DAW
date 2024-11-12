package Programacion.Tema3.Array;

public class EjercicioClase5 {
    public static void main(String[] args) throws Exception {
        /*
        * Vamos a simular que tenemos un sensor de temperatura en una plantacion de tomates
        * El dispositivo toma la temperatura 120 veces al dia
        * Simula el comportamiento del sensor con un array de double
        * que represente la temperatura tomada por el sensor
        *
        * Si la temperatura media actual es superior a un umbral(35 grados)
        * debe saltar una alarma (throw Exception)
        * */

        double temp[] = new double[120];
        boolean alarma = false;
        double suma = 0;


            for (int i = 0; i < temp.length; i++) {
                temp[i] = generarnumAleatorio(13, 40);
                suma += temp[i];
                System.out.println("Temperatura actual de invernadero: "+ (suma / (i+1)));

                if ((suma / (i+1)) > 35) {
                    System.out.println("Alarma, temperatura fuera del umbral");
                    break;
                }
        }



    }
    public static int generarnumAleatorio(int menor, int mayor) {
        return (int) (Math.random() * (mayor - menor + 1) + menor);

    }
    public static double mediaDeArrayAlaMarcha(double[] numeros, int posicion) {
        double total = 0;
        for (int i = 0; i < posicion; i++) {
            total += numeros[i];
        }
        total = total / posicion;
        return total;
    }
}
