package org.example.java8practicequestions;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String s = "rarcrxecas";
        System.out.println("Input: " + s);

        // LinkedHashMap to store characters and their counts
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        // Iterate over each character and count occurrences
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Find the first character with a count of 1
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("First non-repeating character: " + entry.getKey());
                return;
            }
        }

        // If no non-repeating character is found
        System.out.println("First non-repeating character: -");
    }
}
