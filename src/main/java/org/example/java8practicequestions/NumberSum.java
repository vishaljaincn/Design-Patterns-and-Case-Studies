package org.example.java8practicequestions;

import java.util.*;
import java.util.stream.Collectors;

public class NumberSum {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 2, 3, 3, 4, 5, 5, 6, 7, 8, 8, 9, 9, 9, 10);

        // Q1: How can you find the sum of even numbers in a list using Java Streams?
        int sumOfEvens = numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum of even numbers: " + sumOfEvens);
        System.out.println("----------------------------------------------------------------");

        // Q2: How can you find the sum of even numbers using the reduce method?
        Optional<Integer> sumOfEven = numbers.stream()
                .filter(num -> num % 2 == 0)
                .reduce(Integer::sum);
        System.out.println("Sum of even numbers using reduce: " + sumOfEven.orElse(0));
        System.out.println("----------------------------------------------------------------");

        // Q3: How can you find the sum of odd numbers in a list?
        int sumOfOdds = numbers.stream()
                .filter(num -> num % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum of odd numbers: " + sumOfOdds);
        System.out.println("----------------------------------------------------------------");

        // Q4: How can you find the maximum number in a list using Java Streams?
        int max = numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(NoSuchElementException::new);
        System.out.println("Max of numbers: " + max);
        System.out.println("----------------------------------------------------------------");

        // Q5: How can you remove duplicates from a list using Java Streams?
        List<Integer> numWithoutdup = numbersWithDuplicates.stream()
                .distinct().toList();
        numWithoutdup.forEach(num -> System.out.print(num + " "));
        System.out.println();

        // Q6: How can you use method references to print distinct elements in a list?
        numbersWithDuplicates.stream()
                .distinct().forEach(System.out::print);
        System.out.println("----------------------------------------------------------------------");

        // Q7: How can you find duplicates in a list using Java Streams?
        Set<Integer> set = new HashSet<>();
        numbersWithDuplicates.stream()
                .filter(i -> !set.add(i))
                .forEach(System.out::print);
        System.out.println("--------------------------------------------------------------------------");

        // Q8: How can you find the first non-repetitive character in a string?
        String input = "Java Hungry Blog blog blog blog Alive is Awesome";

        Character firstNonRepetitive = input.chars()
                .mapToObj(s -> Character.toLowerCase((char) s))
                .collect(Collectors.groupingBy(i -> i, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(i -> i.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println("First non-repetitive character is " + firstNonRepetitive);

        // Q9: What happens when you convert a string to a character array and print its length?
        String input1 = "Java Hungry Blog blog blog blog Alive is Awesome";
        char[] c = input.toCharArray();
        System.out.println(c);
        System.out.println(c.length);

        // Q10: How can you group characters in a string by their occurrence?
        Map<Character, List<Character>> map = input1.chars()
                .mapToObj(i -> Character.toLowerCase((char) i))
                .collect(Collectors.groupingBy(i -> i));
        System.out.println(map);

        // Q11: How can you find the first non-repetitive character in a string without using Java 8 features?
        String input3 = "Java Hungry Blog Alive is Awesome";
        Character firstNonRepetitive1 = findFirstNonRepetitiveCharacter(input3);
        System.out.println("First non-repetitive character is " + firstNonRepetitive1);
    }

    // Q11: How can you find the first non-repetitive character in a string without using Java 8 features?
    public static Character findFirstNonRepetitiveCharacter(String input) {
        // LinkedHashMap to maintain the order of insertion
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();

        // First pass: Count occurrences of each character
        for (char c : input.toCharArray()) {
            Character lowerCaseChar = Character.toLowerCase(c);
            charCountMap.put(lowerCaseChar, charCountMap.getOrDefault(lowerCaseChar, 0) + 1);
        }

        // Second pass: Find the first character with a count of 1
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return null; // Return null if no non-repetitive character is found
    }
}
