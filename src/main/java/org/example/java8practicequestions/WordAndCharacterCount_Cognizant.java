package org.example.java8practicequestions;

public class WordAndCharacterCount_Cognizant {

    public static void main(String[] args) {
        String input = "++ Hi Vishal ***";

        int validWordCount = countValidWords(input);
        int specialCharacterCount = countSpecialCharacters(input);

        System.out.println("Valid word count: " + validWordCount);
        System.out.println("Special character count: " + specialCharacterCount);
    }

    private static int countValidWords(String input) {
        String[] words = input.split("\\s+"); // Split by whitespace
        int count = 0;

        for (String word : words) {
            if (word.matches("[a-zA-Z0-9]+")) { // Only letters and numbers
                count++;
            }
        }
        return count;
    }

    private static int countSpecialCharacters(String input) {
        int specialCharacterCount = 0;

        for (char c : input.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                specialCharacterCount++;
            }
        }
        return specialCharacterCount;
    }
}
