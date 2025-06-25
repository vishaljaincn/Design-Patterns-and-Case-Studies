package org.example.java8practicequestions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class demonstrates different ways to sort a HashMap by keys and values
 * using Java 8 Stream API and Comparators.
 */
public class SortHashMapByKeyAndValues {
    public static void main(String[] args) {
        // Create and populate a sample HashMap
        Map<String, Integer> unsortedMap = new HashMap<>();
        unsortedMap.put("banana", 2);
        unsortedMap.put("apple", 5);
        unsortedMap.put("cherry", 10);

        System.out.println("Original unsorted map: " + unsortedMap);

        // ===== SORTING BY KEYS =====

        // Method 1: Sort by keys in reverse order using Map.Entry.comparingByKey()
        Map<String, Integer> sortedByKey = unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey((i, j) -> j.compareTo(i)))  // Reverse order
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,     // Merge function for duplicate keys (not needed here)
                        LinkedHashMap::new   // Preserves insertion order
                ));
        System.out.println("\n1. Sorted by keys (descending): " + sortedByKey);

        // Method 2: Sort by keys in reverse order using Comparator.comparing().reversed()
        Map<String, Integer> sortedByKeys = unsortedMap.entrySet()
                .stream()
                .sorted(Comparator.<Map.Entry<String, Integer>, String>comparing(Map.Entry::getKey).reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        System.out.println("2. Sorted by keys (descending): " + sortedByKeys);

        // ===== SORTING BY VALUES =====

        // Method 1: Sort by values in ascending order using Map.Entry.comparingByValue()
        Map<String, Integer> sortedByValues = unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())  // Natural ordering (ascending)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        System.out.println("\n3. Sorted by values (ascending): " + sortedByValues);

        // Method 2: Sort by values in descending order using Comparator.comparing().reversed()
        Map<String, Integer> sortedByValuesDescending = unsortedMap.entrySet()
                .stream()
                .sorted(Comparator.<Map.Entry<String, Integer>, Integer>comparing(Map.Entry::getValue).reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}
