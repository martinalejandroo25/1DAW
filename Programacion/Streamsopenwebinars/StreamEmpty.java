package Programacion.Streamsopenwebinars;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamEmpty {
    public static void main(String[] args) {

        Stream<String> nameStream = Stream.empty();

        List<String> names2 = new ArrayList<>();

        names2.add("name1") ;
        names2.add("name2");
        names2.add("name3");
        Stream<String> nameStream2 = names2.stream();

        Stream<String> names = Stream.concat(nameStream, nameStream2);
    }
}
