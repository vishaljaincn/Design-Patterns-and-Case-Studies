package org.example.java8practicequestions;

import java.util.Arrays;

public class OverloadedMain {

    public static void main(String[] args) {
        // Entry point of the program
        System.out.println("Executing the main method...");

        // Demonstrating method overloading with different parameter types
        processNumbers(new int[]{1, 2, 3});  // Passing an array of integers
        processNumber(6);                     // Passing a single integer
        processString("vishal");              // Passing a string
    }

    // Method to process an array of integers
    private static void processNumbers(int[] numbers) {
        System.out.println("Processing an array of numbers: " + Arrays.toString(numbers));
    }

    // Method to process a single integer
    private static void processNumber(int number) {
        System.out.println("Processing a single number: " + number);

        // Creating a new array of integers and processing it
        int[] additionalNumbers = {10, 20, 30};
        processNumbers(additionalNumbers);  // Call to the array processing method
    }

    // Method to process a string
    private static void processString(String input) {
        System.out.println("Processing a string: " + input);
    }
}
