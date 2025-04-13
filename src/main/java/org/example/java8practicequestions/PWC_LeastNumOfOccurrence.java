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

        // Initialize the first character as the 'temp' character to be tracked, and set the count to 1
        char temp = chars[0];
        int count = 1;

        // Iterate over the string starting from the second character
        for (int i = 1; i < chars.length; i++) {
            // If the current character matches the 'temp' character, increase the count
            if (chars[i] == temp) {
                count++;
            } else {
                // If the character changes, check if 'temp' is already in the map
                // If so, store the minimum of the previous and current consecutive occurrences
                if (map.containsKey(temp)) {
                    map.put(temp, Math.min(map.get(temp), count));
                } else {
                    // If 'temp' is not in the map, put it with the current count
                    map.put(temp, count);
                }
                // Reset the 'temp' to the new character and the count to 1
                temp = chars[i];
                count = 1;
            }
        }

        // Handle the last character sequence after the loop ends
        if (map.containsKey(temp)) {
            map.put(temp, Math.min(map.get(temp), count));
        } else {
            map.put(temp, count);
        }

        // Print the resulting HashMap which contains the minimum consecutive occurrences of each character
        System.out.println(map);

    }
}
