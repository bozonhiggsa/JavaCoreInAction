package net.core.tutorial.elementary._25_Collections._05_ImmutableList;

/**
 * Entry point
 * @author Ihor Savchenko
 * @version 1.0
 */

public class Main {

    public static void main(String[] args) {

        new ImmutableListJava()
                .givenUsingTheJdk_whenUnmodifiableListIsCreated_thenNotModifiable();

        new ImmutableListGuava1()
                .givenUsingGuava_whenUnmodifiableListIsCreated_thenNotModifiable();

        new ImmutableListGuava2()
                .givenUsingGuavaBuilder_whenUnmodifiableListIsCreated_thenNoLongerModifiable();

        new ImmutableListApacheCommonsCollections()
                .givenUsingCommonsCollections_whenUnmodifiableListIsCreated_thenNotModifiable();
    }
}
