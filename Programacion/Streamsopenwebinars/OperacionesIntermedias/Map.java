package Programacion.Streamsopenwebinars.OperacionesIntermedias;

import java.util.ArrayList;
import java.util.List;

public class Map {

    public static void main(String[] args) {

        List<String> texts = new ArrayList<>();
        texts.add("ddd2");
        texts.add("aaa2");
        texts.add("bbb1");
        texts.add("aaa1");
        texts.add("bbb3");
        texts.add("ccc");
        texts.add("bbb2");

//        texts.stream()
//                .map(text -> text.length())
//                .forEach(System.out::println);

        texts.stream()
                .map(String::length)
                .forEach(System.out::println);

        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Producto1", 9.99));
        productos.add(new Producto("Producto2", 19.99));
        productos.add(new Producto("Producto3", 29.99));
        productos.add(new Producto("Producto4", 39.99));
        productos.add(new Producto("Producto5", 49.99));

        productos.stream()
                .map(Producto::getPrice)
                .filter(price -> price > 10.0)
                .forEach(System.out::println);

        texts.stream()
                .map(String::toUpperCase).forEach(System.out::println);

    }
}
