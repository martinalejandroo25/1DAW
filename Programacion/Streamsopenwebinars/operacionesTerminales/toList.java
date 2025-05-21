package Programacion.Streamsopenwebinars.operacionesTerminales;

import Programacion.Streamsopenwebinars.OperacionesIntermedias.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class toList {

    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Producto1", 9.99));
        productos.add(new Producto("Producto2", 19.99));
        productos.add(new Producto("Producto3", 29.99));
        productos.add(new Producto("Producto4", 39.99));
        productos.add(new Producto("Producto5", 49.99));

        List<Double> prices = productos.stream()
                .map(Producto::getPrice)
                .filter(price -> price > 10.0)
                .collect(Collectors.toList());
        System.out.println(prices);

        List<Double> prices2 = productos.stream()
                .map(Producto::getPrice)
                .filter(price -> price > 10.0)
                .toList();
        System.out.println(prices2);
    }
}
