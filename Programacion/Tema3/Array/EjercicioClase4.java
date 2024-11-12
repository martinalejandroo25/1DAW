package Programacion.Tema3.Array;

public class EjercicioClase4 {
    public static int generarnumAleatorio(int menor, int mayor) {
        return (int) (Math.random() * (mayor - menor + 1) + menor);

    }
    public static void pintarArray(boolean numeros[]) {
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("["+numeros[i]+"], ");
        }
    }
    public static void main(String[] args) {
        boolean faltas[] = new boolean[85];
        int num = 0;
        int conta=0;
        int limite = 20 * faltas.length / 100;
        for (int i = 0; i < faltas.length; i++) {
            if ((num = generarnumAleatorio(0, 1)) == 0)
                faltas[i] = true;
            else
                faltas[i] = false;
            pintarArray(faltas);
            if (!faltas[i])
                conta++;
            System.out.println();
            System.out.println("El alumno tiene "+conta+" de "+faltas.length+" faltas");
            if (conta > limite) {
                System.out.println("pierde la evaluacion continua");
                break;
            }
            else {
                System.out.println("Vienes a menudo a clase, muy bien");
                break;
            }
        }

    }
}
