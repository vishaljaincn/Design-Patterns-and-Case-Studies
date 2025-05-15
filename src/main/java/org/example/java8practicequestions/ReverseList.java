package org.example.java8practicequestions;

import java.util.List;

public class ReverseList {

    // Method to reverse a string using StringBuilder
    public String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString(); // Reverses and returns the string
    }

    // Static method to reverse a string using manual character swapping
    public static String reverseStrings(String str) {
        int i = 0;
        int j = str.length() - 1;
        char[] arr = str.toCharArray(); // Convert the string to character array

        // Reverse the array by swapping characters
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        return new String(arr); // Return the reversed string
    }

    public static void main(String[] args) {
        // Create an immutable list of strings
        List<String> str = List.of("Rajath", "Anil Macharam", "Akhil Jain", "Vishal Jain", "Ajay Jain", "Ajith Jain");

        // 1. Stream: Sort in decreasing order of length, reverse each string using reverseStrings(), print result
        str.stream()
                .sorted((i, j) -> j.length() - i.length()) // Sort by length (longest first)
                .map(ReverseList::reverseStrings)          // Reverse each string using static method
                .forEach(System.out::println);             // Print each reversed string
        System.out.println("-----------------");

        // 2. Stream: Same sort, but reverse each string using StringBuilder inside lambda
        str.stream()
                .sorted((i, j) -> j.length() - i.length()) // Again sort by length (longest first)
                .map(i -> new StringBuilder(i).reverse().toString()) // Reverse using inline StringBuilder
                .forEach(System.out::println);             // Print each reversed string
        System.out.println("-----------------");

        // 3. Stream: Same sort, reverse each string using instance method reverseString()
        ReverseList reverseList = new ReverseList();  // Create instance to call non-static method
        str.stream()
                .sorted((i, j) -> j.length() - i.length()) // Again sort by length (longest first)
                .map(reverseList::reverseString)           // Reverse using instance method
                .forEach(System.out::println);             // Print each reversed string
        System.out.println("-----------------");

        // 4. Stream: Alphabetical sort (default), reverse using instance method
        str.stream()
                .sorted()                                  // Sort alphabetically (natural order)
                .map(reverseList::reverseString)           // Reverse using instance method
                .forEach(System.out::println);             // Print each reversed string
    }
}
