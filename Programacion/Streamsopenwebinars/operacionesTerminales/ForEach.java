package Programacion.Streamsopenwebinars.operacionesTerminales;

import Programacion.Streamsopenwebinars.OperacionesIntermedias.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ForEach {

    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Producto1", 9.99));
        productos.add(new Producto("Producto2", 19.99));
        productos.add(new Producto("Producto3", 29.99));
        productos.add(new Producto("Producto4", 39.99));
        productos.add(new Producto("Producto5", 49.99));

        productos.stream()
                .filter(producto -> producto.getPrice() > 10.0)
                .forEach(producto -> producto.setPrice(producto.getPrice() + producto.getPrice() * 0.21));
        System.out.println(productos);

    }
}
