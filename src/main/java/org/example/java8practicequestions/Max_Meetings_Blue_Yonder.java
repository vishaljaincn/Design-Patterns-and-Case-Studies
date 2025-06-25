package org.example.java8practicequestions;

import java.util.Arrays;

/*
Problem Statement:
Given time intervals determine if a person could attend all meetings: Given an array of meeting time
intervals consisting of start and end times [[s1,e1],[s2,e2],…] (si < ei), determine if a person could
attend all meetings.

Solution Approach:
1. Sort all meetings by their start time
2. Check if any meeting starts before the previous one ends (which indicates an overlap)
3. If any overlap is found, return false (cannot attend all meetings)
4. If no overlaps are found, return true (can attend all meetings)

Time Complexity: O(n log n) due to sorting
Space Complexity: O(1) for in-place sort (excluding input)

Example:
Meetings: [[1,5], [6,10], [11,15], [5,9]]
After sorting: [[1,5], [5,9], [6,10], [11,15]]
Overlap check: Meeting [6,10] starts at 6 which is before [5,9] ends - overlap detected!
Result: Cannot attend all meetings
*/
class Meeting {
    public int start;
    public int end;

    // Constructor
    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Max_Meetings_Blue_Yonder {
    public static boolean canAttendAllMeetings(Meeting[] intervals) {
        // Sort the intervals by their start time
        Arrays.sort(intervals, (a, b) -> a.start - b.start);

        // Iterate through the sorted intervals and check for overlaps
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                // Overlap found
                return false;
            }
        }

        // No overlaps found, can attend all meetings
        return true;
    }

    public static void main(String[] args) {
        // Example meeting intervals
        Meeting[] meetings = {
                new Meeting(1, 5),
                new Meeting(6, 10),
                new Meeting(11, 15),
                new Meeting(5, 9) // This one overlaps with the second meeting
        };

        boolean result = canAttendAllMeetings(meetings);
        if (result) {
            System.out.println("The person can attend all meetings.");
        } else {
            System.out.println("The person cannot attend all meetings.");
        }
    }
}
