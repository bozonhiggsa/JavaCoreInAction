package net.core.tutorial.elementary._25_Collections._01_Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SpeedArrayListVersaLinkedList {

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        int lengthOfList = 10_000;

        long startTime11 = System.nanoTime();

        for(int i=0; i < lengthOfList; i++){

            arrayList.add(0, i);
        }

        long stopTime11 = System.nanoTime();

        long startTime12 = System.nanoTime();

        for(int i=0; i < lengthOfList; i++){

            linkedList.add(0, i);
        }

        long stopTime12 = System.nanoTime();

        System.out.println("To past values into first position of ArrayList, it's took time: "
                + (stopTime11 - startTime11) + " ns");
        System.out.println("To past values into first position of LinkedList, it's took time: "
                + (stopTime12 - startTime12) + " ns");
        System.out.println("---------------------------------");

        long startTime21 = System.nanoTime();

        for(int i=0; i < lengthOfList; i++){

            arrayList.get(i);
        }

        long stopTime21 = System.nanoTime();

        long startTime22 = System.nanoTime();

        for(int i=0; i < lengthOfList; i++){

            linkedList.get(i);
        }

        long stopTime22 = System.nanoTime();

        System.out.println("To get values from each position of ArrayList, it's took time: "
                + (stopTime21 - startTime21) + " ns");
        System.out.println("To get values from each position of LinkedList, it's took time: "
                + (stopTime22 - startTime22) + " ns");
        System.out.println("---------------------------------");

        long startTime31 = System.nanoTime();

        for(int i=0; i < lengthOfList; i++){

            arrayList.set(i, i + 1);
        }

        long stopTime31 = System.nanoTime();

        long startTime32 = System.nanoTime();

        for(int i=0; i < lengthOfList; i++){

            linkedList.set(i, i + 1);
        }

        long stopTime32 = System.nanoTime();

        System.out.println("To set new value to each position of ArrayList, it's took time: "
                + (stopTime31 - startTime31) + " ns");
        System.out.println("To set new value to each position of LinkedList, it's took time: "
                + (stopTime32 - startTime32) + " ns");
        System.out.println("---------------------------------");

        long startTime41 = System.nanoTime();

        for(int i=0; i < lengthOfList; i++){

            arrayList.remove(0);
        }

        long stopTime41 = System.nanoTime();

        long startTime42 = System.nanoTime();

        for(int i=0; i < lengthOfList; i++){

            linkedList.remove(0);
        }

        long stopTime42 = System.nanoTime();

        System.out.println("To remove all elements one by one from first position of ArrayList, it's took time: "
                + (stopTime41 - startTime41) + " ns");
        System.out.println("To remove all elements one by one from first position of LinkedList, it's took time: "
                + (stopTime42 - startTime42) + " ns");
    }

}
