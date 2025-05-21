package Programacion.InterfacesFuncionalesOpenWebinars.Consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main1 {

    public static void main(String[] args) {


        // Clases anonimas
        Consumer<String> printer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        printer.accept("Hola mundo");

        //Lambdas
        Consumer<String> printer1 = message -> System.out.println(message);
        Consumer<String> printer2 = message -> System.out.println(message);
        printer2.accept("Hola mundo desde lambda");

        Consumer<String> printer12 = printer1.andThen(printer2);
        printer12.accept("adios");

        List<String> names = new ArrayList<>();

        names.add("names1");
        names.add("names2");
        names.add("names3");

        names.forEach(name -> System.out.println(name));

    }

}
