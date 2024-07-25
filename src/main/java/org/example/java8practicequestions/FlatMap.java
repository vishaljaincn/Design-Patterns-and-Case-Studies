package org.example.java8practicequestions;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {

    public static void main(String[] args) {
        // Q1: How can you flatten a list of lists using Java Streams?
        // Demonstrate the use of flatMap to flatten a nested list structure into a single list.
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("one", "two"),
                Arrays.asList("three", "four"),
                Arrays.asList("five", "six"));

        List<String> flattenedList = listOfLists.stream()
                .flatMap(Collection::stream)
                .toList();
        System.out.println(flattenedList);

        System.out.println("-------------------------------------------------------");
        System.out.println();

        // Q2: How can you use Stream.iterate to generate a sequence of numbers?
        // Generate the first 50 even numbers starting from 0 and print them.
        Stream.iterate(0, i -> i + 2).limit(50).forEach(i -> System.out.print(i + " "));
        System.out.println();

        // Q3: How can you find the most frequently occurring word in a string?
        // Split a given string into words, count the occurrences, and find the word with the highest frequency.
        String s = "I am the new Boss. so I am here the I";

        Entry<String, Long> h1 = Arrays.stream(s.split(" "))
                .collect(Collectors.groupingBy(i -> i, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .max((i, i1) -> i.getValue().compareTo(i1.getValue()))
                .get();

        System.out.println("The most frequent word and its count: " + h1);

        // Q4: How can you filter and display words that appear more than once in a string?
        // Find words with a frequency greater than one and display them with their counts.
        Map<String, Long> h = Arrays.stream(s.split(" "))
                .collect(Collectors.groupingBy(i -> i, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(i -> i.getValue() > 1)
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

        h.forEach((key, value) -> System.out.println("Word: " + key + ", Count: " + value));
    }
}
