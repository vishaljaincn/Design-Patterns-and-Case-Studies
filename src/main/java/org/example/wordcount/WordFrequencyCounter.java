package org.example.wordcount;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordFrequencyCounter {

    /**
     * Counts how many times a specific word appears in the input string.
     *
     * @param input the input string
     * @param word the word to search for
     * @return the number of occurrences of the word
     */
    public static int countWordFrequency(String input, String word) {
        if (input == null || word == null || input.isEmpty() || word.isEmpty()) {
            return 0;
        }

        // Convert to lowercase for case-insensitive comparison
        String wordLowerCase = word.toLowerCase();

        return (int) Arrays.stream(input.toLowerCase().split("\\s+"))
                .filter(w -> w.equals(wordLowerCase))
                .count();
    }

    /**
     * Finds the word with the highest frequency in the input string.
     *
     * @param input the input string
     * @return a map entry containing the most frequent word and its count
     */
    public static Map.Entry<String, Long> findMostFrequentWord(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        return Arrays.stream(input.toLowerCase().split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);
    }

    /**
     * Returns a map of all words and their frequencies.
     *
     * @param input the input string
     * @return a map with words as keys and their frequencies as values
     */
    public static Map<String, Long> getAllWordFrequencies(String input) {
        if (input == null || input.isEmpty()) {
            return Map.of();
        }

        return Arrays.stream(input.toLowerCase().split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static void main(String[] args) {
        String text = "This is a sample text. This text is meant to test the word frequency counter. This sample demonstrates how many times each word appears in a text.";

        // Count occurrences of a specific word
        String targetWord = "text";
        int count = countWordFrequency(text, targetWord);
        System.out.println("The word '" + targetWord + "' appears " + count + " times.");

        // Find the most frequent word
        Map.Entry<String, Long> mostFrequent = findMostFrequentWord(text);
        if (mostFrequent != null) {
            System.out.println("Most frequent word: '" + mostFrequent.getKey() +
                    "' which appears " + mostFrequent.getValue() + " times.");
        }

        // Print all word frequencies in descending order
        System.out.println("\nAll word frequencies:");
        getAllWordFrequencies(text).entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}

