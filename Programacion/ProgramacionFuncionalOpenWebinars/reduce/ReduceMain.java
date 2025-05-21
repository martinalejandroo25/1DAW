package Programacion.ProgramacionFuncionalOpenWebinars.reduce;

import java.util.List;

public class ReduceMain {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1,2,3,4,5,6,7);

        // esfoque tradicional
        Integer aux = 0;
        for (Integer number : numbers) {
            aux += number;
        }

        // lambda
        numbers.stream().reduce(0, (num, num2) -> num + num2);

        //referencia a metodo o method reference
        Integer sum = numbers.stream().reduce(0, Integer::sum);

        System.out.println(sum);


        Integer multiplication = numbers.stream().reduce(1, (num, num2) -> num * num2);
        System.out.println(multiplication);

        numbers.stream().reduce(Integer::max);
        numbers.stream().reduce(Integer::min);
        System.out.println();
    }
}
