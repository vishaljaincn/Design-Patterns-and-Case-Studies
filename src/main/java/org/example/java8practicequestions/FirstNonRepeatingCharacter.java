package org.example.java8practicequestions;

import java.util.LinkedHashSet;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        // Input string
        String s = "racecars";
        System.out.println(s);

        // LinkedHashSet to store characters while maintaining insertion order
        LinkedHashSet<Character> set = new LinkedHashSet<>();

        // Iterate over each character in the string
        for (char c : s.toCharArray()) {
            // If the character already exists in the set, it means it's repeating
            if (set.contains(c)) {
                set.remove(c); // Remove the character from the set (no longer non-repeating)
            } else {
                set.add(c); // Add the character to the set (seen for the first time)
            }
        }
        System.out.println(set.getFirst());
        // Retrieve and print the first character from the set (non-repeating)
        // LinkedHashSet preserves the order of insertion, so the first element is the first non-repeating character
        System.out.println(set.iterator().hasNext() ? set.iterator().next() : '-');
        // If the set is empty, print '-' to indicate no non-repeating character
    }
}
