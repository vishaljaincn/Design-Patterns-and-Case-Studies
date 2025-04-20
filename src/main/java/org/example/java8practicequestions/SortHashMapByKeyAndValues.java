package org.example.java8practicequestions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortHashMapByKeyAndValues {
    public static void main(String[] args) {
        // Create a sample HashMap
        Map<String, Integer> unsortedMap = new HashMap<>();
        unsortedMap.put("banana", 2);
        unsortedMap.put("apple", 5);
        unsortedMap.put("cherry", 10);

        // Sort by keys
        Map<String, Integer> sortedByKey = unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey((i,j)->j.compareTo(i)))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new

                ));

        // Print the sorted map by keys
        System.out.println("Sorted by keys: " + sortedByKey);

        // Sort by values
        Map<String, Integer> sortedByValues = unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new

                ));

        // Print the sorted map by Values
        System.out.println("Sorted by Values: " + sortedByValues);
    }
}
