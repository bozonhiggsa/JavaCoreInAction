package net.core.tutorial.elementary._25_Collections._05_ImmutableList;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Guava also provides a builder – this will returned
 * the strong-typed ImmutableList instead of simply List.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class ImmutableListGuava2 {

    public void givenUsingGuavaBuilder_whenUnmodifiableListIsCreated_thenNoLongerModifiable() {

        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
        ImmutableList<Object> unmodifiableList = ImmutableList.builder().addAll(list).build();
        try{
            unmodifiableList.add("four");
        }
        catch (UnsupportedOperationException e){
            e.getStackTrace();
            System.out.println("ArrayList is immutable. There is an attempt to modify it.");
        }
}
}
