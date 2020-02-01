package net.core.tutorial.elementary._25_Collections._01_Lists.ownListImplementation;

import java.util.Iterator;

/**
 * Entry Point
 * @author Ihor Savchenko
 * @version 1.0
 */

public class EntryPoint {

    public static void main(String[] args) {

        System.out.println("==== Part1");
        MyList list = new MyListImpl();
        // [A, A2]
        list.add("A");
        list.add("A2");
        System.out.println(list);
        // []
        list.clear();
        System.out.println(list);
        // [A, null, A3]
        list.add("A");
        list.add(null);
        list.add("A2");
        list.add("A3");
        list.remove("A2");
        System.out.println(list);
        // AnullA3
        for (Object el : list.toArray()) {
            System.out.print(el);
        }
        System.out.println();
        // 3
        System.out.println(list.size());
        // false
        System.out.println(list.contains("B"));
        // true
        System.out.println(list.contains("A3"));
        // true
        list.add("A2");
        MyList anotherList = new MyListImpl();
        anotherList.add("A");
        anotherList.add("A2");
        System.out.println(list.containsAll(anotherList));
        // false
        anotherList.add("B");
        System.out.println(list.containsAll(anotherList));
        // true
        list.add("B");
        System.out.println(list.containsAll(anotherList));

        System.out.println("==== Part2");

        list = new MyListImpl();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // 1 2 3 4
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        // [1, 3, 4]
        it = list.iterator();
        it.next();
        it.next();
        it.remove();
        System.out.println(list);

        // 3
        System.out.println(it.next());

        // [1, 4]
        it.remove();
        System.out.println(list);
        // class java.lang.IllegalStateException
        try {
            it.remove();
        } catch (IllegalStateException ex) {
            System.out.println(ex.getClass());
        }

        System.out.println("==== Part3");

        list = new MyListImpl();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // 1 2 3 4
        ListIterator lit = ((ListIterable)list).listIterator();
        while (lit.hasNext()) {
            System.out.print(lit.next() + " ");
        }
        System.out.println();
        // 4 3 2 1
        while (lit.hasPrevious()) {
            System.out.print(lit.previous() + " ");
        }
        System.out.println();

        list = new MyListImpl();
        lit = ((ListIterable)list).listIterator();
        // false
        System.out.println(lit.hasNext());

        // false
        System.out.println(lit.hasPrevious());
        // Element
        list.add("Element");
        System.out.println(lit.next());

        // false
        System.out.println(lit.hasNext());

        // true
        System.out.println(lit.hasPrevious());
    }
}

