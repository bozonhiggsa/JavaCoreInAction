package net.core.tutorial.elementary._25_Collections._01_Lists;

import java.util.ArrayList;
import java.util.List;

public class ListWithObjects {

    public static void main(String[] args) {

        List<String> list1 = new ArrayList<>();

        list1.add("Oleg");
        list1.add("Ivan");
        list1.add("Maxim");

        System.out.println("List size is : " + list1.size());
        System.out.println("Does list contain String? : " + list1.contains("Ivan"));
        list1.remove("Maxim");
        System.out.println("List size is : " + list1.size());
        System.out.println("--------------------");

        List<Person1> list2 = new ArrayList<>();

        list2.add(new Person1("Oleg", 20));
        list2.add(new Person1("Ivan", 22));
        list2.add(new Person1("Maxim", 26));

        System.out.println("List size is : " + list2.size());
        System.out.println("Does list contain person? : " + list2.contains(new Person1("Oleg", 20)));
        list2.remove(new Person1("Maxim", 26));
        System.out.println("List size is : " + list2.size());
        System.out.println("--------------------");

        List<Person2> list3 = new ArrayList<>();

        list3.add(new Person2("Oleg", 20));
        list3.add(new Person2("Ivan", 22));
        list3.add(new Person2("Maxim", 26));

        System.out.println("List size is : " + list3.size());
        System.out.println("Does list contain person? : " + list3.contains(new Person2("Oleg", 20)));
        list3.remove(new Person2("Maxim", 26));
        System.out.println("List size is : " + list3.size());
        System.out.println("--------------------");
    }
}
