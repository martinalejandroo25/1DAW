package Programacion.Streamsopenwebinars;

import java.util.UUID;
import java.util.stream.Stream;

public class StreamsGenerate {

    public static void main(String[] args) {

        //Stream infinitos
        Stream<String> uuidStream = Stream.generate(() -> UUID.randomUUID().toString());
        uuidStream.limit(20).forEach(System.out::println);

        Stream<Integer> numGenerator = Stream.iterate(0, num -> num + 1);
        numGenerator.limit(10).forEach(System.out::println);
    }
}
