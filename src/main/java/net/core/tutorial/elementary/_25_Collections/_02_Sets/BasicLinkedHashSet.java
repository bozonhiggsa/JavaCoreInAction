package net.core.tutorial.elementary._25_Collections._02_Sets;

import java.util.LinkedHashSet;
import java.util.Set;

public class BasicLinkedHashSet {

    public static void main(String[] args) {

        Set<Person2> set1 = new LinkedHashSet<>();

        System.out.println("Set is empty? : " + set1.isEmpty());
        System.out.println("Set size : " + set1.size());
        System.out.println("-----------------------");

        set1.add(new Person2("Irina", 20));
        set1.add(new Person2("Anna", 30));
        set1.add(new Person2("Elena", 40));
        System.out.println("Set is empty? : " + set1.isEmpty());
        System.out.println("Set size : " + set1.size());
        System.out.println("-----------------------");
        for (Person2 person2: set1){
            System.out.println(person2);
        }
    }
}