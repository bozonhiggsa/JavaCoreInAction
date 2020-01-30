package net.core.tutorial.elementary._25_Collections._02_Sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BasicIterator {

    public static void main(String[] args) {

        Set<Person2> set = new HashSet<>();

        set.add(new Person2("Neo", 20));
        set.add(new Person2("Gleb", 30));
        set.add(new Person2("Max", 40));

        Iterator<Person2> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("---------------------");

        for (Person2 person: set){
            System.out.println(person);
        }
    }
}
