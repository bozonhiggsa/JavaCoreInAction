package net.core.tutorial.proficient._01_ConcurrencyAdvanced.facilitiesForList;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Example - how to remove duplicates from a List.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class TestRemoveDuplicatesFromList {

    // Java8 solution using Lambdas;
    // using the distinct() method from the Stream API
    // which returns a stream consisting of distinct elements
    // based on the result returned by equals() method.
    @Test
    public void givenListContainsDuplicates_whenRemovingDuplicatesWithJava8_thenCorrect() {

        List<Integer> listWithDuplicates = Lists.newArrayList(1, 1, 2, 2, 3, 3);
        List<Integer> listWithoutDuplicates = listWithDuplicates.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
