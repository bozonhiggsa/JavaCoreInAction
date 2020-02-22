package net.core.tutorial.medium._07_EntryToCollectionStream.example2;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EntryPoint {
    private static List<Employee> employees = Arrays.asList(
            new Employee("Alex", "Sanin", 1, 20, Position.WORKER),
            new Employee("Olga", "Senina", 2, 30, Position.WORKER),
            new Employee("Sveta", "Genina", 223, 40, Position.WORKER),
            new Employee("Serg", "Benina", 122, 50, Position.MANAGER),
            new Employee("Ivan", "Orlov", 22, 35, Position.WORKER),
            new Employee("Masha", "Alenev", 2234, 55, Position.MANAGER),
            new Employee("Michal", "Kenina", 21, 35, Position.WORKER),
            new Employee("Elena", "Penina", 2342, 34, Position.WORKER),
            new Employee("Stas", "Denina", 122, 33, Position.WORKER),
            new Employee("Serg", "Senina", 265, 31, Position.CHIEF),
            new Employee("Olga", "Orlova", 268, 40, Position.WORKER),
            new Employee("Irina", "Senenko", 32435, 41, Position.WORKER),
            new Employee("Irina", "Sirenko", 22757, 42, Position.MANAGER),
            new Employee("Olga", "Abazov", 2432, 54, Position.WORKER),
            new Employee("Masha", "Lipin", 29, 67, Position.WORKER)
    );

    private static List<Department> departments = Arrays.asList(
            new Department(0, 0, "Head"),
            new Department(1, 1, "East"),
            new Department(2, 1, "West"),
            new Department(3, 1, "North"),
            new Department(5, 2, "Germany"),
            new Department(6, 2, "Ukraine"),
            new Department(7, 2, "Japan"),
            new Department(8, 3, "USA")
    );

    public static void main(String[] args) throws IOException {
        // Create stream of lines from file
        Stream<String> lines = Files.lines(Paths.get("some_text.txt"));
        // Create stream of objects from some directory
        Stream<Path> list = Files.list(Paths.get("./"));
        // Create stream of paths for file system tree
        // 3 level for tree
        Stream<Path> walk = Files.walk(Paths.get("./"), 3);

        // Stream for integers
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5, 6, 7, 9);
        DoubleStream doubleStream = DoubleStream.of(1.3, 4.5, 7.8, 9.0);

        // Create stream from integers with range
        IntStream.range(10, 100); // 10 .. 99
        IntStream.rangeClosed(10, 100); // 10 .. 100

        // Create stream from array
        int[] ints = {1,2,3,4,5,9};
        IntStream streamFromArray = Arrays.stream(ints);

        // Create stream from objects
        Stream<String> stringsStream = Stream.of("name", "surname", "age", "height");
        Stream<? extends Serializable> streamFromObjects = Stream.of(1, "surname", "age", "height");

        // Create builder for stream
        Stream<String> build = Stream.<String> builder()
                .add("Name")
                .add("Age")
                .add("Weight")
                .build();

        // Create stream from collection
        Stream<Employee> streamOfEmployees = employees.stream();
        Stream<Employee> streamOfEmployees2 = employees.parallelStream();

        // Create stream from function
        // Generating endless sequence
        Stream<Event> generate = Stream.generate(() -> new Event(UUID.randomUUID(), LocalDateTime.now(), ""));

        // Create endless sequence
        Stream<Integer> iterate = Stream.iterate(1800, val -> val + 5);

        // Concatenate two streams
        Stream<String> concat = Stream.concat(stringsStream, build);

    }
}
