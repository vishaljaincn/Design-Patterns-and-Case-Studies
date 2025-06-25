package org.example.java8practicequestions;

public class ReverseUppercaseWords {
    public static void main(String[] args) {
        String input = "welcome to AUTOMATION TESTING";
        String output = reverseUppercaseWords(input);
        System.out.println(output);  // Output: welcome to NOITAMOTUA GNITSET
    }

    public static String reverseUppercaseWords(String input) {
        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.equals(word.toUpperCase())) {  // Check if word is all uppercase
                result.append(new StringBuilder(word).reverse()).append(" ");
            } else {
                result.append(word).append(" ");
            }
        }

        return result.toString().trim();  // Remove trailing space
    }
}
