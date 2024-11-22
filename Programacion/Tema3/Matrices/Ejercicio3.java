package Programacion.Tema3.Matrices;

public class Ejercicio3 {
    public static int generarnumAleatorio(int menor, int mayor) {
        return (int) (Math.random() * (mayor - menor + 1) + menor);

    }

    public static void main(String[] args) {
        double sensores[][] = new double[6][3];

        //1
        for (int i = 0; i < sensores.length; i++) {
            sensores[i][0] = generarnumAleatorio(-5, 55);
            sensores[i][1] = generarnumAleatorio(0, 100);
            sensores[i][2] = generarnumAleatorio(0, 10);

        }

        //2
        for (int i = 0; i < sensores.length; i++) {
            System.out.println("Zona " + i);
            System.out.println("Temp " + sensores[i][0]
            + " Humedad: " + sensores[i][1] + " ph: "+ sensores[i][2]);
        }
        //3
        double mediaT=0, mediaH=0, mediaPH=0;
        for (int i = 0; i < sensores.length; i++) {
            mediaT+=sensores[i][0];
            mediaH+=sensores[i][1];
            mediaPH+=sensores[i][2];
        }
        System.out.println("Media Temperatura zonas "+ mediaT/sensores.length);
        System.out.println("Media Humedad zonas "+ mediaH/sensores.length);
        System.out.println("Media PH zonas "+ mediaPH/sensores.length);

        //4
        double maxT = -5;
        int numZona = -1;
        for (int i = 0; i < sensores.length; i++) {
            if (sensores[i][0] > maxT) {
                maxT = sensores[i][0];
                numZona = i;
            }
        }
        System.out.println("Max de temperatura en zonas es "+ maxT);
        System.out.println("Está en la zona "+ numZona);
        //5
        boolean indicador = false;
        for (int i = 0; i < sensores.length; i++) {
            if (sensores[i][0] < 30) {
                indicador = true;
                break;
            }
        }
        if (indicador) {
            System.out.println("Hay alguna zona con humedad inferior al 30%");
        } else {
            System.out.println("No hay ninguna zona con humedad inferior al 30%H");
        }
    }
}
