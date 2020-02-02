package net.core.tutorial.proficient._01_ConcurrencyAdvanced.facilitiesForList;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Example - how to remove all null elements from a List.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class TestRemoveNullFromList {

    // Java8 solution using Lambdas to filter the List;
    // the filtering process can be done in parallel or serial.
    @Test
    public void givenListContainsNulls_whenFilteringParallel_thenCorrect() {

        List<Integer> list = Lists.newArrayList(null, 1, 2, null, 3, null);
        List<Integer> listWithoutNulls = list.parallelStream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Test
    public void givenListContainsNulls_whenFilteringSerial_thenCorrect() {

        List<Integer> list = Lists.newArrayList(null, 1, 2, null, 3, null);
        List<Integer> listWithoutNulls = list.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    // Java8 solution using Lambdas.
    // If you want to mutate your collection, you can also use the removeIf method,
    // so you don’t have to build a stream.
    @Test
    public void givenListContainsNulls_whenRemovingNullsWithRemoveIf_thenCorrect() {

        final List list = Lists.newArrayList(null, 1, 2, null, 3, null);
        list.removeIf(p -> p == null);
        assertEquals(3, list.size());
    }

}
