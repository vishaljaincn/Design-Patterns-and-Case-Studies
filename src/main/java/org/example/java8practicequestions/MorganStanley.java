package org.example.java8practicequestions;

import java.util.HashMap;

public class MorganStanley {
    public static void main(String[] args) {
        // Input string
        String s = "Aabb";

        // HashMap to store each character and its frequency
        HashMap<Character, Integer> map = new HashMap<>();

        // Loop through each character in the string
        for (int i = 0; i < s.length(); i++) {
            // If the character is already in the map, increment its frequency
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                // Otherwise, add it to the map with a frequency of 1
                map.put(s.charAt(i), 1);
            }
        }

        // Sort the map entries by frequency in descending order and print each character accordingly
        map.entrySet().stream()
                .sorted((i, j) -> Integer.compare(j.getValue(), i.getValue())) // Sort by value in descending order
                .forEach(i -> {
                    // Print each character 'value' times
                    for (int j = 0; j < i.getValue(); j++) {
                        System.out.print(i.getKey());
                    }
                });
    }
}
