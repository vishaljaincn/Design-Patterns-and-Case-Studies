package org.example.java8practicequestions;

import java.util.HashMap;
import java.util.Map.Entry;

public class FirstAndSecondMaxOccurrenceFinder {

    public static void main(String[] args) {
        // Sample input array
        int[] arr = {1, 3, 2, 1, 4, 1, 3, 2, 2, 2, 3};

        // Find and print the two most frequent numbers
        findTopTwoFrequentNumbers(arr);
    }

    public static void findTopTwoFrequentNumbers(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty.");
            return;
        }

        // Step 1: Count occurrences using getOrDefault
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // Count frequency of each number in the array
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Find first and second most frequent numbers
        int firstMaxKey = Integer.MIN_VALUE;
        int secondMaxKey = Integer.MIN_VALUE;
        int firstMaxFreq = Integer.MIN_VALUE;
        int secondMaxFreq = Integer.MIN_VALUE;

        // Iterate through the frequency map to find the top two frequent numbers
        for (Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int key = entry.getKey();
            int freq = entry.getValue();

            // Update first and second max frequencies and their corresponding numbers
            if (freq > firstMaxFreq) {
                // Current becomes second max before updating first max
                secondMaxFreq = firstMaxFreq;
                secondMaxKey = firstMaxKey;

                firstMaxFreq = freq;
                firstMaxKey = key;
            } else if (freq > secondMaxFreq && key != firstMaxKey) {
                // Update second max if current frequency is less than first max but greater than current second max
                secondMaxFreq = freq;
                secondMaxKey = key;
            }
        }

        // Print the results
        System.out.println("Most frequent number: " + firstMaxKey + " (occurred " + firstMaxFreq + " times)");
        if (secondMaxFreq != Integer.MIN_VALUE) {
            System.out.println("Second most frequent number: " + secondMaxKey + " (occurred " + secondMaxFreq + " times)");
        } else {
            System.out.println("No distinct second most frequent number.");
        }
    }
}
