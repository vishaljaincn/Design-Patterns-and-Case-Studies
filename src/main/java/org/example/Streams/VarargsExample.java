package org.example.Streams;

import java.util.Arrays;

public class VarargsExample {

    // Method with varargs
    public static void printNumbers(int... numbers) {
        int[] a = numbers;
        System.out.println(Arrays.toString(a));
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Invoking varargs method with different numbers of arguments
        printNumbers(1, 2, 3);            // Output: 1 2 3
        printNumbers(10, 20);             // Output: 10 20
        printNumbers(5);                  // Output: 5
        printNumbers();                   // Output: (no output)

        // Storing varargs in an array
        int[] array = {7, 8, 9};
        printNumbers(array);              // Output: 7 8 9
    }
}
