import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MaxOccurrenceFinder {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1, 4, 1, 3, 2, 2, 2, 3};

        findTopTwoFrequentNumbers(arr);
    }

    public static void findTopTwoFrequentNumbers(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty.");
            return;
        }

        // Step 1: Count occurrences using getOrDefault
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Find first and second most frequent numbers
        int firstMaxKey = Integer.MIN_VALUE;
        int secondMaxKey = Integer.MIN_VALUE;
        int firstMaxFreq = Integer.MIN_VALUE;
        int secondMaxFreq = Integer.MIN_VALUE;

        for (Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int key = entry.getKey();
            int freq = entry.getValue();

            if (freq > firstMaxFreq) {
                secondMaxFreq = firstMaxFreq;
                secondMaxKey = firstMaxKey;

                firstMaxFreq = freq;
                firstMaxKey = key;
            } else if (freq > secondMaxFreq && key != firstMaxKey) {
                secondMaxFreq = freq;
                secondMaxKey = key;
            }
        }

        System.out.println("Most frequent number: " + firstMaxKey + " (occurred " + firstMaxFreq + " times)");
        if (secondMaxFreq != Integer.MIN_VALUE) {
            System.out.println("Second most frequent number: " + secondMaxKey + " (occurred " + secondMaxFreq + " times)");
        } else {
            System.out.println("No distinct second most frequent number.");
        }
    }
}
