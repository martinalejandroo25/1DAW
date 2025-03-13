package Programacion.Tema6.PracticaPDF1.Ejercicio3;

import java.util.ArrayList;

public class Ejecutable {
    public static void main(String[] args) {
        ArrayList<Serie> series = new ArrayList<>();
        ArrayList<Videojuego> videojuegos = new ArrayList<>();

        Serie s1 = new Serie("Juego de Tronos", "Rey");
        Serie s2 = new Serie("Stranger Things", "Los hermanitos");
        Serie s3 = new Serie("Tokyo Ghoul", "Los chinitos arigato");

        Videojuego v1 = new Videojuego("Poppy playtime", "Terror", "Mob Entertainment");
        Videojuego v2 = new Videojuego("The Last of Us Part II", 100, "Nvidia", "Naughty Dog");
        Videojuego v3 = new Videojuego("Red Dead Redemption 2", 120, "Rockstar Games", "Treyarch");

        series.add(s1);
        series.add(s2);
        series.add(s3);

        videojuegos.add(v1);
        videojuegos.add(v2);
        videojuegos.add(v3);

        s1.entregar();
        v2.entregar();

        System.out.println(series);
        System.out.println();
        System.out.println(videojuegos);

        imprimirPrestadoSerie(series);
        imprimirPrestadoVideojuego(videojuegos);

    }


    private static void imprimirPrestadoSerie(ArrayList<Serie> series) {
        int contaprestado=0;
        int contaNOprestado=0;
        for (Serie serie : series) {
            if (serie.isPrestado()) {
                System.out.println(serie.getTitulo() + " está prestado");
                contaprestado++;
            } else {
                System.out.println(serie.getTitulo() + " no está prestado");
                contaNOprestado++;
            }
        }
        System.out.println("Total series prestadas: " + contaprestado);
        System.out.println("Total series no prestadas: " + contaNOprestado);
    }
    private static void imprimirPrestadoVideojuego(ArrayList<Videojuego> videojuegos) {
        int contaprestado=0;
        int contaNOprestado=0;
        for (Videojuego videojuego : videojuegos) {
            if (videojuego.isPrestado()) {
                System.out.println(videojuego.getTitulo() + " está prestado");
                contaprestado++;
            } else {
                System.out.println(videojuego.getTitulo() + " no está prestado");
                contaNOprestado++;
            }
        }
        System.out.println("Total series prestadas: " + contaprestado);
        System.out.println("Total series no prestadas: " + contaNOprestado);
    }
}
