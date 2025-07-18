package org.example.java8practicequestions;

import java.util.Arrays;

public class MaxProductFinder {

    public static int findMaxProduct(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }

        int n = arr.length;

        // Sort the array
        Arrays.sort(arr);

        // Two possibilities for maximum product:
        // 1. Product of two largest numbers (both positive or both negative)
        // 2. Product of two smallest numbers (both negative, resulting in positive)
        int product1 = arr[n-1] * arr[n-2];
        int product2 = arr[0] * arr[1];

        return Math.max(product1, product2);
    }

    public static void main(String[] args) {
        // Example usage
        int[] arr = {-10, -3, 5, 6, -20, 4};
        System.out.println("Maximum product: " + findMaxProduct(arr));

        // Additional test cases
        int[] arr2 = {1, 4, 3, 6, 7, 0};
        System.out.println("Maximum product: " + findMaxProduct(arr2));

        int[] arr3 = {-5, -4, -3, -2, -1};
        System.out.println("Maximum product: " + findMaxProduct(arr3));
    }
}

