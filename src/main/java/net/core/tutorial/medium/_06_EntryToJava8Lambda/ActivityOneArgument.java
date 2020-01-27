package net.core.tutorial.medium._06_EntryToJava8Lambda;

/**
 * Interface for use with a Lambda expressions.
 * @author Ihor Savchenko
 * @version 1.0
 */
@FunctionalInterface
public interface ActivityOneArgument {

    void write(String message);

    boolean equals(Object o);
    String toString();
    int hashCode();
}
