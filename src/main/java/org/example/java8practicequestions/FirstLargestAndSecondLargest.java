package org.example.java8practicequestions;

/*
Time Complexity: O(n)
Space Complexity: O(1)
 */
public class FirstLargestAndSecondLargest {
    public static void main(String[] args) {
        // Sample input array
        int[] arr = {12, 35, 1, 10, 34, 1};

        // Check if array has at least two elements
        if (arr.length < 2) {
            System.out.println("Array should contain at least two elements.");
            return;
        }

        // Initialize first and second largest to minimum integer value
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        // Traverse the array to find the first and second largest elements
        for (int num : arr) {
            if (num > first) {
                // Update both first and second largest
                second = first;
                first = num;
            } else if (num > second && num != first) {
                // Update second largest if current number is less than first but greater than second
                second = num;
            }
        }

        // Output the results
        System.out.println("First largest: " + first);
        if (second != Integer.MIN_VALUE) {
            System.out.println("Second largest: " + second);
        } else {
            // Handle case where there is no distinct second largest element
            System.out.println("There is no distinct second largest element.");
        }
    }
}
