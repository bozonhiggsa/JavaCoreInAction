package net.core.tutorial.medium._07_EntryToCollectionStream;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Test2 {

    public static void main(String[] args) {

        Set<String> set = new TreeSet<>(new Comparator<String>() {
            public int compare(String s, String s2) {
                return s.length() - s2.length();
            }
        });


        Set<String> set2 = new TreeSet<String>((s, s2) -> s.length() - s2.length());

        set.add("12345");
        set.add("1234567");
        set.add("123");

        System.out.println(set);

        set2.add("12345");
        set2.add("1234567");
        set2.add("123");

        System.out.println(set2);
    }
}
