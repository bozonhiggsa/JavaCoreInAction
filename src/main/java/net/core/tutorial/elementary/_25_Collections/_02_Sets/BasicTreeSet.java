package net.core.tutorial.elementary._25_Collections._02_Sets;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class BasicTreeSet {

    public static void main(String[] args) {

        Set<String> setStrings = new TreeSet<>();

        setStrings.add("Oleg");
        setStrings.add("Oleg");
        setStrings.add("Uliana");
        setStrings.add("Ivan");
        setStrings.add("Alex");

        System.out.println(setStrings);
        System.out.println("Set size : " + setStrings.size());
        System.out.println("Set contains string? : " + setStrings.contains("Uliana"));

        System.out.println("----------------------");

        Set<Person3> setPersons = new TreeSet<>();
        setPersons.add(new Person3("Oleg", 30));
        setPersons.add(new Person3("Oleg", 40));
        setPersons.add(new Person3("Uliana", 30));
        setPersons.add(new Person3("Ivan", 50));
        setPersons.add(new Person3("Ivan", 20));
        setPersons.add(new Person3("Alex", 60));
        System.out.println(setPersons);
        System.out.println("Set size : " + setPersons.size());
        System.out.println("Set contains person? : " + setPersons.contains(new Person3("Oleg", 70)));

        System.out.println("----------------------");

        Set<Person3> setPersons2 = new TreeSet<>(new Comparator<Person3>() {
            @Override
            public int compare(Person3 p1, Person3 p2) {
                if(p1.getName().compareTo(p2.getName()) == 0){
                    if(p1.getAge() == p2.getAge()){
                        return 0;
                    }
                    else return (p1.getAge() - p2.getAge());
                }
                else return p1.getName().compareTo(p2.getName());
            }
        });
        setPersons2.add(new Person3("Oleg", 30));
        setPersons2.add(new Person3("Oleg", 40));
        setPersons2.add(new Person3("Uliana", 30));
        setPersons2.add(new Person3("Ivan", 50));
        setPersons2.add(new Person3("Ivan", 20));
        setPersons2.add(new Person3("Alex", 60));
        System.out.println(setPersons2);
        System.out.println("Set size : " + setPersons2.size());
        System.out.println("Set contains person? : " + setPersons2.contains(new Person3("Oleg", 70)));
    }
}
