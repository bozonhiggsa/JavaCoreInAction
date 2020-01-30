package net.core.tutorial.elementary._25_Collections._02_Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BasicHashSet {

    public static void main(String[] args) {

        Set<Person1> set1 = new HashSet<>();

        System.out.println("Set is empty? : " + set1.isEmpty());
        System.out.println("Set size : " + set1.size());
        System.out.println("-----------------------");

        set1.add(new Person1("Irina", 20));
        set1.add(new Person1("Anna", 30));
        set1.add(new Person1("Elena", 40));
        System.out.println("Set is empty? : " + set1.isEmpty());
        System.out.println("Set size : " + set1.size());
        System.out.println("-----------------------");
        System.out.println(set1);
        for (Person1 person1: set1){
            System.out.println(person1);
        }

        System.out.println("-----------------------");

        set1.add(new Person1("Irina", 20));
        for (Person1 person1: set1){
            System.out.println(person1);
        }

        System.out.println("-----------------------");

        set1.add(new Person1("Irina", 20));
        for (Person1 person1: set1){
            System.out.println(person1.getName());
        }

        System.out.println("-----------------------");

        ArrayList<Person2> list = new ArrayList<>();
        list.add(new Person2("Anna", 30));
        list.add(new Person2("Anna", 30));
        list.add(new Person2("Anna", 30));
        System.out.println(list);
        Set<Person2> set2 = new HashSet<>(list);
        System.out.println(set2);

        System.out.println("-----------------------");

        set2.add(new Person2("Max", 40));
        set2.add(new Person2("Gleb", 30));
        set2.add(new Person2("Neo", 20));
        Person2[] arrayPersons = set2.toArray(new Person2[set2.size()]);
        System.out.println(Arrays.toString(arrayPersons));

    }
}
