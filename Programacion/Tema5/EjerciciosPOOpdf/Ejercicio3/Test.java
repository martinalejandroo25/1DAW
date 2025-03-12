package Programacion.Tema5.EjerciciosPOOpdf.Ejercicio3;

public class Test {
    public static void main(String[] args) {
        Libreria libreria = new Libreria();

        libreria.adquirir(new Libro("ISBN0001", "Libro 1", "Autor 1", 230, false), 19.99);
        libreria.adquirir(new Libro("ISBN0002", "Libro 2", "Autor 2", 250, false), 25.99);
        libreria.adquirir(new Libro("ISBN0003", "Libro 3", "Autor 3", 140, false), 14.85);

        libreria.vender(new Libro("ISBN0002", "libro1", "autor1", 123, false));
        libreria.vender(new Libro("ISBN0001", "libro1", "autor1", 123, false));
        libreria.vender(new Libro("ISBN0003", "libro1", "autor1", 123, false));

        System.out.println("Ganancias totales: " + libreria.calcularGanancias());

    }
}
