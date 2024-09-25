package org.example.java8practicequestions;

public class Deloitte {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        System.out.println(binarySearch(a, 9000));
    }

    static public boolean binarySearch(int[] array, int element) {
        for (int low = 0, high = array.length - 1; low <= high; ) {
            int mid = low + (high - low) / 2;
            if (array[mid] == element) return true;
            low = (array[mid] < element) ? mid + 1 : low;
            high = (array[mid] > element) ? mid - 1 : high;
        }
        return false;
    }
}
