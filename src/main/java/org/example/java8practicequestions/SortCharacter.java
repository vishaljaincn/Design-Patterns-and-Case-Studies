package org.example.java8practicequestions;

import java.util.TreeSet;

/*
String str1 = "bbbaaadddcccfffeee";
a b c d e f
 */
public class SortCharacter {
    public static void main(String[] args) {
        String str1 = "bbbaaadddcccfffeee";

        // Create an array to store frequency of characters from 'a' to 'z'
        int[] freq = new int[26];

        // Count frequency of each character
        for (char ch : str1.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Print only the characters that appear in the string
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                System.out.print((char) (i + 'a') + " ");
            }
        }

        // Create a TreeSet to store unique characters in sorted order
        TreeSet<Character> sortedChars = new TreeSet<>();

        // Add each character from the string to the TreeSet
        for (char ch : str1.toCharArray()) {
            sortedChars.add(ch);
        }
        System.out.println();
        // Print the characters in sorted order with spaces in between
        for (char ch : sortedChars) {
            System.out.print(ch + " ");
        }
    }
}
