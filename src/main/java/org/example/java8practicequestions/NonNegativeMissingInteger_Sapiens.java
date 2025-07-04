package org.example.java8practicequestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//[9,10,2,3,4,-1,-8,-2,0,1,45,6,7,8,1]
// smallest non negative missing number
//O(N) - TC
//O(N) - SC
public class NonNegativeMissingInteger_Sapiens {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(9, 10, 2, 3, 4, -1, -8, -2, 0, 1, 4, 5, 6, 7, 8, 1, 11, 12);
        HashSet<Integer> set = new HashSet<>();
        for (int num : list) {
            if (num >= 0) {
                set.add(num);
            }
        }

        int missing = 0;
        while (true) {
            if (!set.contains(missing)) {
                System.out.println("The first non-negative missing integer is " + missing);
                return;
            }
            missing++;
        }
    }
}