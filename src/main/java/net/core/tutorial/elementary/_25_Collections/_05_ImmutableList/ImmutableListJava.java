package net.core.tutorial.elementary._25_Collections._05_ImmutableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The JDK provides a nice way to get
 * an unmodifiable collection out of an existing one.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class ImmutableListJava {

    public void givenUsingTheJdk_whenUnmodifiableListIsCreated_thenNotModifiable() {

        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
        List<String> unmodifiableList = Collections.unmodifiableList(list);
        try{
            unmodifiableList.add("four");
        }
        catch (UnsupportedOperationException e){
            e.getStackTrace();
            System.out.println("ArrayList is immutable. There is an attempt to modify it.");
        }
    }
}
