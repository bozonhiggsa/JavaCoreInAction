package net.core.tutorial.medium._07_EntryToCollectionStream.example2;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
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
            new Employee("Elena", "Penina", 2342, 84, Position.WORKER),
            new Employee("Stas", "Denina", 122, 33, Position.WORKER),
            new Employee("Serg", "Senina", 265, 31, Position.CHIEF),
            new Employee("Olga", "Orlova", 268, 40, Position.WORKER),
            new Employee("Irina", "Senenko", 32435, 41, Position.WORKER),
            new Employee("Irina", "Sirenko", 22757, 42, Position.MANAGER),
            new Employee("Olga", "Abazov", 2432, 54, Position.WORKER),
            new Employee("Masha", "Lipin", 29, 67, Position.WORKER)
    );

    private static List<Department> departments = Arrays.asList(
            new Department(1, 0, "Head"),
            new Department(2, 1, "East"),
            new Department(3, 1, "West"),
            new Department(4, 1, "North"),
            new Department(5, 2, "Germany"),
            new Department(6, 2, "Ukraine"),
            new Department(7, 3, "Japan"),
            new Department(8, 4, "USA")
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
        IntStream range = IntStream.range(10, 100);// 10 .. 99
        IntStream range1 = IntStream.rangeClosed(10, 100);// 10 .. 100

        // Create stream from array
        int[] ints = {1,2,3,4,5,9};
        IntStream streamFromArray = Arrays.stream(ints);

        // Create stream from objects
        Stream<String> stringsStream = Stream.of("name", "surname", "age", "height");
        Stream<? extends Serializable> streamFromObjects = Stream.of(1, "surname", "age", "height");
        Stream<? extends Serializable> streamFromEmployees = Stream.of(
                new Employee("Igor", "Ivanov", 77, 40, Position.WORKER),
                new Employee("Igor", "Ivanov", 77, 40, Position.WORKER),
                new Employee("Igor", "Ivanov", 77, 40, Position.WORKER)
        );

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
        Stream<Double> generate2 = Stream.generate(Math :: random);
        Stream<Integer> generate3 = Stream.generate(() -> 10);

        // Create endless sequence
        Stream<Integer> iterate = Stream.iterate(1800, val -> val + 5);

        // Concatenate two streams. Origin streams will close after concat()
        Stream<String> concat = Stream.concat(stringsStream, build);

        streamFromArray.forEach(System.out :: println);
        System.out.println("-------------------");
        System.out.println(lines.count());

        System.out.println("-------------------");
        try{
            build.forEach(System.out :: println);
        } catch(Exception e){
            System.out.println("IllegalStateException has happened because stream is already closed");
        }
        // After terminal operation stream is closed
        System.out.println("-------------------");
        try{
            build.forEach(System.out :: println);
        } catch(Exception e){
            System.out.println("IllegalStateException has happened because stream is already closed");
        }

        System.out.println("-------------------");
        streamOfEmployees.forEach(el -> System.out.println(el.getName()));
        System.out.println("-------------------");
        employees.forEach(el -> System.out.println(el.getName()));

        System.out.println("-------------------");
        // for parallel stream is guaranteed that orders of elements will retain
        streamOfEmployees2.forEachOrdered(el -> System.out.println(el.getName()));

        System.out.println("-------------------");
        // transform stream to other type of collection
        Stream<Department> departmentStream = departments.stream();
        Set<Department> departmentsSet = departmentStream.collect(Collectors.toSet());
        departments.stream().toArray();
        Map<Integer, String> integerStringMap = departments.stream().collect(Collectors.toMap(
                Department::getId,
                deps -> String.format("%s : %d", deps.getName(), deps.getParent())
        ));
        for (Map.Entry<Integer, String> map : integerStringMap.entrySet()) {
            System.out.println(map.getKey() + " : " + map.getValue());
        }

        System.out.println("-------------------");
        //Reduce of stream
        OptionalInt addInt = IntStream.of(1, 2, 3, 4, 5, 6, 7).reduce((left, right) -> left + right);
        System.out.println(addInt);
        System.out.println(addInt.getAsInt());

        System.out.println("-------------------");
        Optional<Department> reduceDepartments = departments.stream().reduce(EntryPoint::reducer);
        System.out.println(reduceDepartments);

        System.out.println("--------------------");
        // for numbers stream
        IntStream.of(10, 20, 30, 40).average();
        IntStream.of(10, 20, 30, 40).min();
        IntStream.of(10, 20, 30, 40).max();
        DoubleStream.of(10.8, 20.9, 30.1, 40.05).average();
        DoubleStream.of(10.8, 20.9, 30.1, 40.05).sum();
        double average = DoubleStream.of(10.8, 20.9, 30.1, 40.05).summaryStatistics().getAverage();
        System.out.println(average);

        System.out.println("---------------------");
        Optional<Employee> maxAgeEmployee = employees.stream().max((emp1, emp2) -> emp1.getAge() - emp2.getAge());
        System.out.println("Employee with max age is " + maxAgeEmployee);
        Optional<Employee> minAgeEmployee = employees.stream().min((emp1, emp2) -> emp1.getAge() - emp2.getAge());
        System.out.println("Employee with max age is " + minAgeEmployee);

        System.out.println("---------------------");
        



    }

    // recursion for adding childs to parent
    public static Department reducer(Department parent, Department child) {
        if(parent.getId() == child.getParent()){
            parent.getChilds().add(child);
        } else{
            parent.getChilds().forEach(subParent -> reducer(subParent, child));
        }
        return parent;
    }
}
