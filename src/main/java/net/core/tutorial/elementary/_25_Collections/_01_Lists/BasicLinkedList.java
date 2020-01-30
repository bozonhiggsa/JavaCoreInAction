package net.core.tutorial.elementary._25_Collections._01_Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BasicLinkedList {

    public static void main(String[] args) {

        List<Integer> list1 = new LinkedList<>();
        System.out.println("List1 is empty? : " + list1.isEmpty());
        System.out.println("List1 size : " + list1.size());
        System.out.println("-----------------------");
        list1.add(1);
        list1.add(2);
        list1.add(3);
        System.out.println("List1 is empty? : " + list1.isEmpty());
        System.out.println("List1 size : " + list1.size());
        System.out.println("-----------------------");
        list1.remove(2);
        System.out.println("List1 size : " + list1.size());
        System.out.println("-----------------------");
        list1.clear();
        System.out.println("List1 is empty? : " + list1.isEmpty());
        System.out.println("List1 size : " + list1.size());
        System.out.println("-----------------------");
        list1.add(100);
        list1.add(200);
        list1.add(300);
        System.out.println("List1 size : " + list1.size());
        System.out.println("List1 contains number? : " + list1.contains(100));
        System.out.println("-----------------------");

        List<Integer> list2 = new ArrayList<>(list1);
        System.out.println("List2 size : " + list2.size());
        System.out.println("List2 contains number? : " + list2.contains(100));
        System.out.println("Is list1 equal list2 ? : " + list1.equals(list2));

        System.out.println("-----------------------");

        LinkedList<Integer> list3 = new LinkedList<>(list2);
        System.out.println("List3 size : " + list3.size());
        System.out.println("Read first element : " + list3.peek());
        System.out.println("Read last element : " + list3.peekLast());
        System.out.println("List3 size : " + list3.size());
        System.out.println("Poll first element : " + list3.poll());
        System.out.println("Poll last element : " + list3.pollLast());
        System.out.println("List3 size : " + list3.size());
        list3.addFirst(3);
        list3.addLast(30);
        System.out.println("List3 size : " + list3.size());
        System.out.println("List3 contains number? : " + list3.contains(30));
        System.out.println("Is list3 equal list2 ? : " + list3.equals(list2));
    }
}
