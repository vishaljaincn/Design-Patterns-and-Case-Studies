package org.example.java8practicequestions;

import java.util.Arrays;

/*
🔍 Problem Summary:

We are given arrival and departure times of n trains.
A platform is needed for each train as soon as it arrives.
If one train departs before another arrives, the same platform can be reused.
We need to find the minimum number of platforms required so that no train waits.
 */
public class TrainPlatform_Sapiens {

    public static int findMinimumPlatforms(int[] arrivals, int[] departures) {
        // Sort both arrays
        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int n = arrivals.length;
        int platformsNeeded = 0, maxPlatforms = 0;
        int i = 0, j = 0;

        // Traverse both arrays
        while (i < n && j < n) {
            if (arrivals[i] <= departures[j]) {
                // A train arrives before the previous departs => need one more platform
                platformsNeeded++;
                i++;
            } else {
                // A train has departed => free a platform
                platformsNeeded--;
                j++;
            }
            // Track maximum platforms needed at any time
            maxPlatforms = Math.max(maxPlatforms, platformsNeeded);
        }

        return maxPlatforms;
    }

    public static void main(String[] args) {
        int[] arrivals = {900, 940, 950, 1100, 1500, 1800};
        int[] departures = {910, 1200, 1120, 1130, 1900, 2000};

        int platforms = findMinimumPlatforms(arrivals, departures);
        System.out.println("Minimum number of platforms required: " + platforms);
    }
}
