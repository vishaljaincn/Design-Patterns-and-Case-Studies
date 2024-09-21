package org.example.java8practicequestions;

import java.util.*;

public class StreamExample {

    // Method to find the second largest number in a list of integers using streams
    public static Optional<Integer> findSecondLargest(List<Integer> numbers) {
        return numbers.stream()
                .filter(Objects::nonNull)    // Handle null values
                .distinct()                 // Remove duplicates
                .sorted((i, j) -> j - i)    // Sort in descending order
                .skip(1)                    // Skip the first element (largest)
                .findFirst();               // Get the second element
    }

    // Method to return a list of strings that start with a specific letter and are sorted in reverse order
    public static List<String> filterAndSortStrings(List<String> strings, char startingLetter) {
        return strings.stream()
                .filter(Objects::nonNull)    // Handle null values
                .filter(i -> i.toLowerCase().startsWith(String.valueOf(startingLetter).toLowerCase()))  // Case-insensitive check
                .sorted((i, j) -> j.compareTo(i))  // Sort in reverse order
                .toList();                   // Collect into a list
    }

    // Method to find the sum of squares of even numbers from a list of integers
    public static int sumOfSquaresOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(Objects::nonNull)    // Handle null values
                .filter(i -> i % 2 == 0)     // Filter even numbers
                .map(i -> i * i)             // Square them
                .reduce(0, Integer::sum);    // Sum them
    }

    public static void main(String[] args) {
        // Test cases to cover edge scenarios

        // Normal cases
        List<Integer> list = Arrays.asList(2, 4, 1, 3, 5, 8, 7, 6);
        List<String> strings = Arrays.asList("vishal", "vipul", "virat", "nigga", "rahul");
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);

        System.out.println(findSecondLargest(list));  // Output: Optional[7]
        List<String> filteredStrings = filterAndSortStrings(strings, 'n');
        System.out.println(filteredStrings);  // Output: [nigga]
        System.out.println(sumOfSquaresOfEvenNumbers(list1));  // Output: 20 (2^2 + 4^2)

        // Edge case: Empty lists
        System.out.println(findSecondLargest(Collections.emptyList()));  // Output: Optional.empty()
        System.out.println(filterAndSortStrings(Collections.emptyList(), 'a'));  // Output: []
        System.out.println(sumOfSquaresOfEvenNumbers(Collections.emptyList()));  // Output: 0

        // Edge case: Null values in list
        List<Integer> listWithNulls = Arrays.asList(2, null, 4, null, 6);
        System.out.println(findSecondLargest(listWithNulls));  // Output: Optional[4] (second largest ignoring nulls)

        List<String> stringsWithNulls = Arrays.asList("apple", null, "banana", "null");
        System.out.println(filterAndSortStrings(stringsWithNulls, 'a'));  // Output: [apple]

        System.out.println(sumOfSquaresOfEvenNumbers(listWithNulls));  // Output: 56 (2^2 + 4^2 + 6^2)

        // Edge case: Duplicates
        List<Integer> duplicatesList = Arrays.asList(5, 5, 5);
        System.out.println(findSecondLargest(duplicatesList));  // Output: Optional.empty() (no second distinct element)

        // Edge case: Case insensitivity
        List<String> mixedCaseStrings = Arrays.asList("apple", "Apple", "banana", "Banana");
        System.out.println(filterAndSortStrings(mixedCaseStrings, 'a'));  // Output: [apple, Apple]
    }
}
