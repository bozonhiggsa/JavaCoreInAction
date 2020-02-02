package net.core.tutorial.elementary._25_Collections._05_ImmutableList;

import org.apache.commons.collections.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Commons Collection provides an API to create an unmodifiable list.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class ImmutableListApacheCommonsCollections {

    public void givenUsingCommonsCollections_whenUnmodifiableListIsCreated_thenNotModifiable() {

        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
        List<String> unmodifiableList = ListUtils.unmodifiableList(list);
        try{
            unmodifiableList.add("four");
        }
        catch (UnsupportedOperationException e){
            e.getStackTrace();
            System.out.println("ArrayList is immutable. There is an attempt to modify it.");
        }
    }
}
