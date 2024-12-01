package org.example.java8practicequestions;

import java.util.Arrays;

public class Regex {
    public static void main(String[] args) {
        // Define a string with extra spaces between words
        String a = "a good     example";

        // Trim the string to remove leading and trailing whitespace
        a = a.trim();

        // Split the string into an array of words using a regular expression
        // that matches one or more whitespace characters (\\s+)
        String[] words = a.split("\\s+");

        // Print the resulting array of words to the console
        System.out.println(Arrays.toString(words));
    }
}
