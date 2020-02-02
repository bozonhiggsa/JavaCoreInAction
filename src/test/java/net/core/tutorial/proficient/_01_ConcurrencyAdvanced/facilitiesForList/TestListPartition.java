package net.core.tutorial.proficient._01_ConcurrencyAdvanced.facilitiesForList;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Example - how to split a List into several
 * sublists of a given size.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class TestListPartition {

    // Guava facilitates partitioning the List into sublists
    // of a specified size – via the Lists.partition operation.
    @Test
    public void givenList_whenPartitioningIntoNSublists_thenCorrect() {

        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        List<List<Integer>> subSets = Lists.partition(intList, 3);

        List<Integer> lastPartition = subSets.get(2);
        List<Integer> expectedLastPartition = Lists.newArrayList(7, 8);
        assertThat(subSets.size(), equalTo(3));
        assertThat(lastPartition, equalTo(expectedLastPartition));
    }

    // Partitioning a Collection is also possible with Guava.
    @Test
    public void givenCollection_whenPartitioningIntoNSublists_thenCorrect() {

        Collection<Integer> intCollection = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);

        Iterable<List<Integer>> subSets = Iterables.partition(intCollection, 3);

        List<Integer> firstPartition = subSets.iterator().next();
        List<Integer> expectedLastPartition = Lists.newArrayList(1, 2, 3);
        assertThat(firstPartition, equalTo(expectedLastPartition));
    }

    // The partitions are sublist views of the original collection – which means that
    // changes in the original collection will be reflected in the partitions.
    @Test
    public void givenListPartitioned_whenOriginalListIsModified_thenPartitionsChangeAsWell() {

        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        List<List<Integer>> subSets = Lists.partition(intList, 3);

        intList.add(9);

        List<Integer> lastPartition = subSets.get(2);
        List<Integer> expectedLastPartition = Lists.newArrayList(7, 8, 9);
        assertThat(lastPartition, equalTo(expectedLastPartition));
    }

    // Java8 to partition the List.
    // We can use Collectors.partitioningBy() to split the list into 2 sublists.
    // The resulting partitions are not a view of the main List,
    // so any changes happen to the main List won’t affect the partitions.
    @Test
    public void givenList_whenPartitioningIntoSublistsUsingPartitionBy_thenCorrect() {

        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);

        Map<Boolean, List<Integer>> groups =
                intList.stream().collect(Collectors.partitioningBy(s -> s > 6));
        List<List<Integer>> subSets = new ArrayList<>(groups.values());

        List<Integer> lastPartition = subSets.get(1);
        List<Integer> expectedLastPartition = Lists.newArrayList(7, 8);
        assertThat(subSets.size(), equalTo(2));
        assertThat(lastPartition, equalTo(expectedLastPartition));
    }

    // We also can use Collectors.groupingBy() to split the list to multiple partitions.
    // Just as Collectors.partitioningBy() – the resulting partitions won’t be affected
    // by changes in main List.
    @Test
    public final void givenList_whenPartitioningIntoNSublistsUsingGroupingBy_thenCorrect() {

        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);

        Map<Integer, List<Integer>> groups =
                intList.stream().collect(Collectors.groupingBy(s -> (s - 1) / 3));
        List<List<Integer>> subSets = new ArrayList<>(groups.values());

        List<Integer> lastPartition = subSets.get(2);
        List<Integer> expectedLastPartition = Lists.<Integer> newArrayList(7, 8);
        assertThat(subSets.size(), equalTo(3));
        assertThat(lastPartition, equalTo(expectedLastPartition));
    }

    // We can also use Java8 to split the List by separator.
    // We used “0” as separator – we first obtained the indices of all “0” elements
    // in the List, then we split the List on these indices.
    @Test
    public void givenList_whenSplittingBySeparator_thenCorrect() {

        List<Integer> intList = Lists.newArrayList(1, 2, 3, 0, 4, 5, 6, 0, 7, 8);

        int[] indexes =
                Stream.of(IntStream.of(-1), IntStream.range(0, intList.size())
                        .filter(i -> intList.get(i) == 0), IntStream.of(intList.size()))
                        .flatMapToInt(s -> s).toArray();
        List<List<Integer>> subSets =
                IntStream.range(0, indexes.length - 1)
                        .mapToObj(i -> intList.subList(indexes[i] + 1, indexes[i + 1]))
                        .collect(Collectors.toList());

        List<Integer> lastPartition = subSets.get(2);
        List<Integer> expectedLastPartition = Lists.<Integer> newArrayList(7, 8);
        assertThat(subSets.size(), equalTo(3));
        assertThat(lastPartition, equalTo(expectedLastPartition));
    }
}
