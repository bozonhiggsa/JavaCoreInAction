package net.core.tutorial.elementary._25_Collections._01_Lists.ownListImplementation;

/**
 * @author Ihor Savchenko
 * @version 1.0
 */
public interface MyList extends Iterable<Object> {

    // appends the specified element to the end of this list
    void add(Object e);

    // removes all of the elements from this list
    void clear();

    // removes the first occurrence of the specified element
    // from this list
    boolean remove(Object o);

    // returns an array containing all of the elements
    // in this list in proper sequence
    Object[] toArray();

    // returns the number of elements in this list
    int size();

    // returns true if this list contains the specified element
    boolean contains(Object o);

    // returns true if this list contains all of the elements
    // of the specified list
    boolean containsAll(MyList c);
}

