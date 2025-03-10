package Programacion.Tema5.EjerciciosPOOpdf.Ejercicio3;

import java.util.ArrayList;

public class Libreria {
    private ArrayList<Libro> libreria = new ArrayList<Libro>(1000);

        //El metodo adquirir asignará
        //un precio_compra al libro y lo añadirá a la librería.
        public void adquirir(Libro libro, double precioCompra) {
            libro.setPrecioCompra(precioCompra);
            libreria.add(libro);
        }

        //El metodo vender pondrá el precio de venta y le
    //cambiará el estado a “vendido = true”.
        public void vender(String ISBN, double precioVenta) {

        libro.setPrecioVenta(precioVenta);
        libro.setVendido(true);
    }

    //un metodo en Librería que calcule las
    //ganancias de todos los libros que hayas vendido.
    public double calcularGanancias() {
            double ganancias = 0;
            for (Libro libro : libreria) {
                if (libro.isVendido()) {
                    ganancias += libro.getPrecioVenta() - libro.getPrecioCompra();
                }
            }
            return ganancias;
    }
}
