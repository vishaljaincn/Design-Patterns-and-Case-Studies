package org.example.java8practicequestions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;


class Employeev {
    private int id;
    private String name;
    private String department;

    public Employeev(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department='" + department + "'}";
    }
}

public class HCLTech {
    public static void main(String[] args) {
        // Predicate to filter employees whose names start with "V"
        Predicate<Employeev> empName = e -> e.getName().startsWith("V");

        // Create a list of Employee objects
        List<Employeev> employeeList = Arrays.asList(
                new Employeev(1, "Vishal", "Raghav"),
                new Employeev(2, "Rahul", "Sinu")
        );

        // Use Stream API to filter employees based on the Predicate and collect the result as a new list
        List<Employeev> filteredList = employeeList.stream()
                .filter(empName)
                .toList();

        // Print the filtered list of employees
        System.out.println("Employees whose names start with 'V': " + filteredList);

        // List of integers for partitioning into even and odd numbers
        List<Integer> list1 = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);

        // Use Stream API to partition the list into even and odd numbers using Collectors.partitioningBy
        Map<Boolean, List<Integer>> partitionedMap = list1.stream()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0));

        // Print the list of even numbers
        System.out.println("List of even numbers: " + partitionedMap.get(true));

        // Print the list of odd numbers
        System.out.println("List of odd numbers: " + partitionedMap.get(false));

        // String to be reversed word by word
        String inputString = "I love India";

        // Split the string into individual words
        String[] words = inputString.split(" ");

        // Initialize an empty string to store the result
        String reversedString = "";

        // Loop through each word, reverse it, and concatenate to the result string
        for (int i = 0; i < words.length; i++) {
            char[] tempArray = words[i].toCharArray();  // Convert word to character array
            reverse(tempArray);                         // Reverse the character array
            reversedString = reversedString + String.valueOf(tempArray) + " ";  // Build the result string
        }

        // Print the final reversed string
        System.out.println("String with each word reversed: " + reversedString);
    }

    /**
     * Method to reverse a given character array in place.
     *
     * @param a The character array to be reversed.
     * @return The reversed character array.
     */
    public static char[] reverse(char[] a) {
        int i = 0;             // Start pointer at the beginning
        int j = a.length - 1;  // End pointer at the end

        // Swap characters from both ends until the pointers meet in the middle
        while (i < j) {
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;  // Move start pointer forward
            j--;  // Move end pointer backward
        }
        return a;
    }
}
