package org.example.java8practicequestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MorganStanley {
    public static void main(String[] args) {
        // Input string to analyze and sort by frequency
        String s = "cnccnnewwnqrntt";

        // Step 1: Count character frequencies using a HashMap
        // Creates a HashMap to store each character and its frequency
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        // Loop through each character in the string
        for (char c : s.toCharArray()) {
            // Increment the frequency of character 'c' in the map
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Section 1: Directly Print Characters by Frequency

        // Stream the entries of the frequency map, sort by frequency (descending), and print each character by frequency
        frequencyMap.entrySet().stream()
                .sorted((i, j) -> Integer.compare(j.getValue(), i.getValue()))  // Sort by frequency in descending order
                .forEach(i -> {
                    // For each entry, print the character 'value' times
                    for (int j = 0; j < i.getValue(); j++) {
                        System.out.print(i.getKey());
                    }
                });

        System.out.println();
        System.out.println("///////");

        // Section 2: Build and Print Sorted String Using StringBuilder

        // Create a StringBuilder to construct the final result string
        StringBuilder result = new StringBuilder();

        // Stream the frequency map entries, sort by frequency (descending), and append characters to the result
        frequencyMap.entrySet().stream()
                .sorted((i, j) -> Integer.compare(j.getValue(), i.getValue()))  // Sort by frequency in descending order
                .forEach(i ->
                        // Append the character 'value' times to the StringBuilder
                        result.append(String.valueOf(i.getKey()).repeat(i.getValue()))
                );
        frequencyMap.entrySet().stream().filter(i -> i.getValue() % 2 == 0).findAny();
        // Print the constructed result string with characters sorted by frequency
        System.out.println(result);
        System.out.println("///////");

        // Section 3: Sort Entries by Frequency and Lexicographical Order, then Build Result String

        // Convert the entries of the frequency map to a list to allow custom sorting
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());

        // Sort the list by frequency in descending order; if equal, sort lexicographically by character
        entryList.sort((e1, e2) -> {
            // Compare by frequency in descending order
            int freqComparison = e2.getValue().compareTo(e1.getValue());
            // If frequencies are equal, sort lexicographically by character
            return freqComparison != 0 ? freqComparison : Character.compare(e1.getKey(), e2.getKey());
        });

        // Use a StringBuilder to build the final sorted string based on the sorted list
        StringBuilder results = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : entryList) {
            // Append each character 'value' times to the StringBuilder
            results.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }

        // Print the final result string sorted by both frequency and lexicographical order when frequencies are tied
        System.out.println(results);
    }
}
