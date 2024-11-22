package Programacion.Tema3.Matrices.EjerciciosClase;

public class Enunciado2 {
    /*2. Simulación sensores de movimiento
Un edificio tiene una matriz de sensores de movimiento simulando una sala.
Tendría una matriz de 5x5, total 25 sensores. Si tiene un 0 una casilla
es que no hay movimiento, si tiene 1, es que sí hay movimiento
- Genera aleatoriamente el estado de los sensores de la sala
- Calcula cuántos sensores están activados
- Identifica si hay una región de movimiento contínuo, es decir al menos un bloque 2x2 con
todos los sensores activados.*/
    public static int generarnumAleatorio(int menor, int mayor) {
        return (int) (Math.random() * (mayor - menor + 1) + menor);

    }

    public static void pintarMatriz(int matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int edificio[][] = new int[5][5];
        int contaAct = 0;
        int zonasAct = 0;

        for (int i = 0; i < edificio.length; i++) {
            for (int j = 0; j < edificio.length; j++) {
                    edificio[i][j] = generarnumAleatorio(0, 1);

                if (edificio[i][j] == 1)
                    contaAct++;
            }
        }
        for (int i = 0; i < edificio.length; i++) {
            for (int j = 0; j < edificio.length; j++) {
                if (i < edificio.length - 1 && j < edificio[i].length - 1 ){
                    if (edificio[i][j] == 1 &&
                            edificio[i][j + 1] == 1 &&
                            edificio[i + 1][j] == 1 &&
                            edificio[i + 1][j + 1] == 1) {
                        zonasAct++;
                    }
                }
            }
        }
        pintarMatriz(edificio);
        System.out.println("Están activados "+contaAct+ " Sensores");
        System.out.println("Hay un total de "+zonasAct+" Zonas Activas(2x2)");
    }
}
