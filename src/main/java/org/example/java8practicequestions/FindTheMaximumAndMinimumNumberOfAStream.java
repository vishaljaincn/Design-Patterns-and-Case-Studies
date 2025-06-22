package org.example.java8practicequestions;

import java.util.*;
import java.util.stream.Stream;

/**
 * This class demonstrates different ways to find minimum and maximum values
 * from collections and streams using Java 8 Stream API.
 *
 * It showcases three different approaches:
 * 1. Using Arrays.asList with Integer::compareTo
 * 2. Using ArrayList with Comparator.comparing
 * 3. Using Stream.of with custom comparators and method references
 */
public class FindTheMaximumAndMinimumNumberOfAStream {

    public static void main(String[] args) {

        // ============= APPROACH 1: Using Arrays.asList =============
        // Creates an immutable list backed by an array, convenient for small fixed-size lists
        List<Integer> list1 = Arrays.asList(5, 4, 2, 10, 3, 8, 6);
        System.out.println(list1);

        // Find the minimum value using Integer::compareTo method reference
        // Integer::compareTo is a method reference that compares two integers naturally
        Optional<Integer> minInteger1 = list1.stream()
                .min(Integer::compareTo);
        // Optional is used to avoid null checks - if the stream is empty, no NullPointerException occurs
        minInteger1.ifPresent(min -> System.out.println("Min Integer is : " + min));

        // Find the maximum value using Integer::compareTo method reference
        // max() returns the maximum element based on the provided comparator
        Optional<Integer> maxInteger1 = list1.stream()
                .max(Integer::compareTo);
        maxInteger1.ifPresent(max -> System.out.println("Max Integer is : " + max));

        // ============= APPROACH 2: Using ArrayList with add method =============
        // Creates a mutable list that can be modified after creation
        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(3);
        list2.add(9);
        list2.add(5);
        list2.add(6);
        list2.add(1);
        list2.add(2);
        System.out.println(list2);

        // Find minimum using Comparator.comparing
        // Comparator.comparing creates a comparator from a function that extracts a comparable key
        // In this case, the lambda i -> i simply returns the integer itself
        Optional<Integer> minInteger2 = list2.stream()
                .min(Comparator.comparing(i -> i));
        minInteger2.ifPresent(System.out::println);  // Using method reference to print the result

        // Find maximum using Comparator.comparing with Integer::valueOf
        // Integer::valueOf is a method reference that converts the integer to an Integer object
        // This is actually redundant here since the list already contains Integer objects
        Optional<Integer> maxInteger2 = list2.stream()
                .max(Comparator.comparing(Integer::valueOf));
        maxInteger2.ifPresent(System.out::println);

        // ============= APPROACH 3: Using Stream.of directly =============
        // Stream.of creates a stream directly from provided values without needing a collection
        // Using a lambda expression (i, j) -> i - j as comparator
        // This works because a positive result means i > j, negative means i < j
        Optional<Integer> minInteger3 = Stream.of(3, 5, 11, 4, 8, 6, 7)
                .min((i, j) -> i - j);
        minInteger3.ifPresent(System.out::println);

        // Find maximum value from Stream.of using Integer::compare method reference
        // Integer.compare(x, y) returns -1 if x < y, 0 if x == y, and 1 if x > y
        Optional<Integer> maxInteger3 = Stream.of(2, 3, 5, 12, 4, 1, 6, 7)
                .max(Integer::compare);
        maxInteger3.ifPresent(System.out::println);
    }
}
