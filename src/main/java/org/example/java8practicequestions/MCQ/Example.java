package org.example.java8practicequestions.MCQ;

import java.util.HashMap;
import java.util.Map;

public class Example {
    // Instance variables
    private final Map<String, Integer> map = new HashMap<>(); // HashMap to store key-value pairs
    private final String text = "Original"; // Immutable String object initialized with "Original"
    private final String text1 = "Original"; // Immutable String object created using the 'new' keyword
    private final StringBuilder stringBuilder = new StringBuilder("Vishal"); // Mutable StringBuilder object

    public static void main(String[] args) {
        // Creating an instance of Example class
        Example example = new Example();
        example.map.put("key1", 1); // Adding an entry to the map

        // Printing the initial values before the method call
        System.out.println("Before method call:");
        System.out.println("Map: " + example.map); // Prints the map content
        System.out.println("String1: " + example.text); // Prints the value of 'text'
        System.out.println("String2: " + example.text1); // Prints the value of 'text1'
        System.out.println("StringBuilder: " + example.stringBuilder); // Prints the content of the StringBuilder

        // Calling the method to modify the values
        example.modifyValues(example.map, example.text, example.text1, example.stringBuilder);

        // Printing the values after the method call
        System.out.println("After method call:");
        System.out.println("Map: " + example.map); // Prints the map content after modification
        System.out.println("String1: " + example.text); // Prints the value of 'text' after the method call
        System.out.println("String2: " + example.text1); // Prints the value of 'text1' after the method call
        System.out.println("StringBuilder: " + example.stringBuilder); // Prints the content of the StringBuilder after modification
    }

    // Method to modify the values
    public void modifyValues(Map<String, Integer> map, String text, String text1, StringBuilder stringBuilder) {
        // Modifying the map by adding a new entry
        map.put("key2", 2);

        // Attempting to modify the String variables
        // Since Strings are immutable, this does not affect the original 'text' and 'text1' variables
        text = "Modified";
        text1 = "Modified";

        // Modifying the StringBuilder object by appending a string
        // StringBuilder is mutable, so this change affects the original StringBuilder object
        stringBuilder.append(" Jain");
    }
}
