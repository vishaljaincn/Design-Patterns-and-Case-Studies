package org.example.java8practicequestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<String> listWithDuplicates = new ArrayList<>();
        listWithDuplicates.add("apple");
        listWithDuplicates.add("banana");
        listWithDuplicates.add("apple");
        listWithDuplicates.add("orange");
        listWithDuplicates.add("banana");
        Map<String, Long> map = listWithDuplicates.stream().collect(Collectors.groupingBy((i -> i), Collectors.counting()));

        List<String> listWithoutDuplicates = listWithDuplicates.stream()
                .distinct()
                .toList();

        System.out.println("List with duplicates: " + listWithDuplicates);
        System.out.println("List without duplicates: " + listWithoutDuplicates);
    }
}
