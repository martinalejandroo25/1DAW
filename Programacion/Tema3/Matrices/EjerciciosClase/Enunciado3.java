package Programacion.Tema3.Matrices.EjerciciosClase;

public class Enunciado3 {

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
        /*3. Simulación de contaminación
Tenemos una ciudad dividida en cuadrantes, una matriz NxM, decide tú.
Cada celda contiene un número entre 0 y 100 indicando el nivel de contaminación.
Pinta una nueva matriz, marcando con un 0 las zonas con contaminación menor a un umbral,
p. ej. 10, con un 1 las zonas entre 10 y 80, y con un 2 las zonas con más de 80.
Dime las coordenadas (i,j) de las zonas con más de 80 de contaminación
Dime también el nivel de contaminación promedio de la ciudad*/
        int ciudad[][] = new int[20][20];
        int contaminacion;
        int mediaCont = 0;
        int contaZonasPeligro = 0;

        for (int i = 0; i < ciudad.length; i++) {
            for (int j = 0; j < ciudad.length; j++) {
                contaminacion = generarnumAleatorio(0,100);
                System.out.println(contaminacion);

                if (contaminacion <= 10){
                    ciudad[i][j] = 0;
                } else if (contaminacion > 10 && contaminacion <= 80){
                    ciudad[i][j] = 1;
                } else if (contaminacion > 80){
                    ciudad[i][j] = 2;
                    contaZonasPeligro++;
                }
            }

        }
        pintarMatriz(ciudad);
        System.out.println(mediaCont);
        System.out.println(ciudad.length);

        int zonas[][] = new int [contaZonasPeligro][2];
        int cont=0;
        for (int i = 0; i < ciudad.length; i++) {
            for (int j = 0; j < ciudad[0].length; j++) {
                if ((ciudad[i][j]) == 2) {
                    zonas[cont][0] = i;
                    zonas[cont][1] = j;
                    cont++;
                    System.out.println("zona de alta contaminación: ("+i+", "+j+")");
                }
            }
        }
        pintarMatriz(zonas);



    }
}
