package net.core.tutorial.elementary._25_Collections._05_ImmutableList;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Guava provides similar functionality for creating
 * its own version of ImmutableList.
 * This operation will actually create a copy
 * of the original list, not just a view.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class ImmutableListGuava1 {

    public void givenUsingGuava_whenUnmodifiableListIsCreated_thenNotModifiable() {

        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
        List<String> unmodifiableList = ImmutableList.copyOf(list);
        try{
            unmodifiableList.add("four");
        }
        catch (UnsupportedOperationException e){
            e.getStackTrace();
            System.out.println("ArrayList is immutable. There is an attempt to modify it.");
        }
    }
}
