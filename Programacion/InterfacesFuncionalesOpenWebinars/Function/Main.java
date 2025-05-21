package Programacion.InterfacesFuncionalesOpenWebinars.Function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        Function<String, Integer> extractLenght = title -> title.length();

        Integer tittleLenght = extractLenght.apply("Hola mundo");
        System.out.println(tittleLenght);

        BiFunction<Integer, Integer, Integer> divider = (num1, num2) -> num1 / num2;
        System.out.println(divider.apply(10,10));
    }
}
