package Programacion.ProgramacionFuncionalOpenWebinars.map;

import Programacion.ProgramacionFuncionalOpenWebinars.Developer;
import Programacion.ProgramacionFuncionalOpenWebinars.Task;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MapDemo {

    public static void main(String[] args) {

        List<String> names = List.of("patricia", "antonio", "juan", "raquel", "juan");
        names.stream()
                .map(String::toUpperCase) //transforma a mayusculas
                .distinct() // elimina duplicados
                .sorted(Comparator.comparing(String::length)) // ordena por longitud
                .forEach(System.out::println); // imprime

        List<Developer> developers = getDevelopers();
        developers.stream()
                .flatMap(dev -> dev.getTasks().stream())
                .filter(task -> task.getHours() > 5)
                .forEach(System.out::println);

        List<Integer> list1 = List.of(1,2,3);
        List<Integer> list2 = List.of(4,5,6);
        List<Integer> list3 = List.of(7,8,9);
        List<List<Integer>> listoflist = List.of(list1, list2, list3);
        List<Integer> results = listoflist.stream()
                .flatMap(list -> list.stream())
                .peek(System.out::println)
                .filter(num -> num > 5)
                .peek(System.out::println)
                .map(num -> num*num)
                .toList();
        System.out.println(results);

    }

    private static List<Developer> getDevelopers(){
        Task task1 = new Task(1L, "task1", 5);
        Task task2 = new Task(2L, "task2", 4);
        Task task3 = new Task(3L, "task3", 6);
        Developer dev1 = new Developer("dev1", 30, List.of(task1, task2, task3));

        Task task4 = new Task(4L, "task4", 2);
        Task task5 = new Task(5L, "task5", 10);
        Task task6 = new Task(6L, "task6", 7);
        Developer dev2 = new Developer("dev2", 30, List.of(task4, task5, task6));

        Task task7 = new Task(7L, "task7", 5);
        Task task8 = new Task(8L, "task8", 4);
        Task task9 = new Task(9L, "task9", 6);
        Developer dev3 = new Developer("dev3", 30, List.of(task7, task8, task9));

        return List.of(dev1, dev2);
    }
}
