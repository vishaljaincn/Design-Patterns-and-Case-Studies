package org.example.java8practicequestions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ZensarTechnologies {
    /**
     * Method to check if a number is prime.
     * Time complexity: O(sqrt(n))
     *
     * @param n The number to check for primality.
     * @return True if the number is prime, false otherwise.
     */
    static boolean isPrime(int n) {
        // Prime numbers are greater than 1
        if (n <= 1) {
            return false;
        }

        // Check divisors from 2 to sqrt(n)
        for (int i = 2; i * i <= n; i++) {
            // If n is divisible by any number between 2 and sqrt(n), it is not prime
            if (n % i == 0) {
                return false;
            }
        }

        // If no divisors were found, n is prime
        return true;
    }

    public static void main(String[] args) {

        // Sample list of strings (words)
        List<String> words = Arrays.asList("apple", "banana", "apple", "", "", "", "orange", "banana", "apple");

        // Q1: How would you filter out all empty strings from the given list and collect the remaining strings into a new list?
        List<String> nonempty = words.stream().filter(s -> !s.isEmpty()).toList();
        System.out.println(nonempty);

        // Q2: How would you count the number of empty strings present in the given list using Java 8 Streams?
        Long value = words.stream().filter(String::isEmpty).count();
        System.out.println(value);

        // Using Java 8 Streams to count word occurrences
        Map<String, Long> wordCount = words.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        // Display the result
        wordCount.forEach((word, count) -> System.out.println(word + ": " + count));

        // Using Java 8 Streams to count word occurrences
        Map<String, Long> wordCounts = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Display the result
        wordCounts.forEach((word, count) -> System.out.println(word + ": " + count));

        // Question: Write a code to count the frequency of each number in a list using Java 8.
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((number, count) -> System.out.println(number + ": " + count));

        // Question: Write a code to display the list of prime numbers using Java 8.

        // Using Java 8 Streams to filter and print prime numbers from the list
        list.stream().filter(i -> isPrime(i)).forEach(System.out::println);
        // Using Java 8 Streams to filter and print prime numbers from the list
        list.stream().filter(ZensarTechnologies::isPrime).forEach(System.out::println);

        // Question: Write a program to check if any prime number exists in the list using Java 8.

        // Check if any number in the list is prime
        boolean containsPrime = list.stream().anyMatch(i -> isPrime(i));
        // Display the result
        if (containsPrime) {
            System.out.println("The list contains prime numbers.");
        } else {
            System.out.println("The list does not contain prime numbers.");
        }

    }

}
