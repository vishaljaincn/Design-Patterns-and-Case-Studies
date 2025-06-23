package org.example.java8practicequestions;

public class LTIMindtree {

    public static void main(String[] args) {
        String input = "Hello World from Java";
        String result = reverseEachWord(input);
        System.out.println(result);  // Output: "olleH dlroW morf avaJ"
    }

    private static String reverseEachWord(String input) {
        StringBuilder reversedSentence = new StringBuilder();
        String[] words = input.split(" ");

        // Reverse each word in place and build the final sentence
        for (String word : words) {
            char[] charArray = word.toCharArray();
            reverseInPlace(charArray);
            reversedSentence.append(String.valueOf(charArray)).append(" ");
        }

        return reversedSentence.toString().trim();
    }

    private static void reverseInPlace(char[] charArray) {
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            // Swap characters
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            // Move towards the middle
            left++;
            right--;
        }
    }
}
