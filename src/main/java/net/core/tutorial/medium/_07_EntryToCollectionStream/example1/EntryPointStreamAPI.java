package net.core.tutorial.medium._07_EntryToCollectionStream.example1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Entry point for a Stream API demonstrating
 * @author Ihor Savchenko
 * @version 1.0
 */
public class EntryPointStreamAPI {

    private static final Logger logger = LoggerFactory.getLogger(EntryPointStreamAPI.class);

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Oleg", "high", 5));
        persons.add(new Person("Ivan", "middle", 3));
        persons.add(new Person("Max", "low", 1));
        persons.add(new Person("Alex", "middle", 10));
        persons.add(new Person("Alex", "middle", 10));
        persons.add(new Person("Inga", "high", 12));
        persons.add(new Person("Katy", "low", 2));

        persons.stream()
                .filter(p -> p.getLevel() >= 3)
                //.sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .sorted(Comparator.comparing(Person::getName))
                .forEach(p -> logger.info(p.toString()));

        logger.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        persons.stream()
                .filter(p -> p.getLevel() >= 3)
                .unordered()
                .distinct()
                .collect(Collectors.toSet())
                .forEach(p -> logger.info(p.toString()));

        logger.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        persons.stream()
                .filter(p -> p.getLevel() >= 3)
                //.limit(2)
                .skip(2)
                .collect(Collectors.toSet())
                .forEach(p -> logger.info(p.toString()));

        logger.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        persons.stream()
                .filter(p -> p.getLevel() >= 3)
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                //.map(p -> p.getExpertise())
                .map(Person::getExpertise)
                //.forEach(p -> logger.info(p));
                .forEach(logger::info);

        logger.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        double averageLevel = persons.stream()
                .filter(p -> p.getLevel() >= 3)
                //.mapToInt(p -> p.getLevel())
                .mapToInt(Person::getLevel)
                .average()
                .getAsDouble();
        logger.info(Double.toString(averageLevel));

        logger.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        logger.info(new EntryPointStreamAPI().intermediateAndTerminalOperations().toString());
    }

    public List<Integer> intermediateAndTerminalOperations(){

        List<String> strings = new LinkedList<>();
        Collection<Integer> users = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> names = users.stream()
                .filter(n -> {
                    strings.add("f-" + n);
                    return n % 2 == 0;
                })
                .map(n -> {
                    strings.add("m-" + n);
                    return n * n;
                })
                .sorted((n1, n2) -> {
                    strings.add("s-" + n1 + "-" + n2);
                    return Integer.compare(n2, n1);
                })
                .limit(2)
                .collect(Collectors.toList());
        strings.forEach(logger::info);

        return names;
    }
}
