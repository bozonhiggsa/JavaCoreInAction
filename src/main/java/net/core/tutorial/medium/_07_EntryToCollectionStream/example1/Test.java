package net.core.tutorial.medium._07_EntryToCollectionStream.example1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        Collection<Integer> col = new ArrayList<>();

        col.add(1);
        col.add(12);
        col.add(72);
        col.add(21);
        col.add(17);

        for (Integer element : col) {
            System.out.print(element + " ");
        }
        System.out.println();

        Iterator<Integer> it = col.iterator();
        while (it.hasNext()) {
            int element = it.next();
            System.out.print(element + " ");
        }
        System.out.println();

        for (Object element : col.toArray()) {
            System.out.print(element + " ");
        }
        System.out.println();

        for (Integer element : col.toArray(new Integer[0])) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println("~~~");
        
        col.forEach(x -> System.out.print(x + " "));
        System.out.println();

        col.forEach((x) -> System.out.print(x + " "));
        System.out.println();

		col.forEach(System.out::print);
		System.out.println();

        String res = col.stream()
                .map(Object::toString)
                .collect(Collectors.joining (" "));
        System.out.println(res);

        StringBuilder sb = new StringBuilder();
        col.forEach(sb::append);
        System.out.println(sb);

    }
}

