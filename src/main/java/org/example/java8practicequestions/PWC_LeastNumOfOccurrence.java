package org.example.java8practicequestions;

import java.util.HashMap;
import java.util.function.Predicate;

public class PWC_LeastNumOfOccurrence {
    public static void main(String[] args) {
        // Question: Find the minimum number of consecutive occurrences of each character in a string.

        String s = "aabbyybbbbcoyc";  // Example input string

        // A HashMap to store the character as the key and its minimum consecutive occurrences as the value.
        HashMap<Character, Integer> map = new HashMap<>();

        // Convert the string into an array of characters
        char[] chars = s.toCharArray();

        int i = 0;
        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            // Count consecutive occurrences using a while loop
            while (i < chars.length && chars[i] == currentChar) {
                count++;
                i++;
            }

            // Update the map with minimum consecutive occurrences
            if (map.containsKey(currentChar)) {
                map.put(currentChar, Math.min(map.get(currentChar), count));
            } else {
                map.put(currentChar, count);
            }
        }

        // Print the resulting HashMap which contains the minimum consecutive occurrences of each character
        System.out.println(map);
    }
}
