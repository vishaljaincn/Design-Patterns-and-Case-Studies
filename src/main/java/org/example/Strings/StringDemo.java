package org.example.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringDemo {
    int variable = 10;

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                c1++;
            } else if (nums[i] == 1) {
                c2++;
            } else {
                c3++;
            }
        }

        System.out.println("c1 " + c1 + " c2 " + c2 + " c3 " + c3);
        for (int i = 0; i < c1; i++) {
            nums[i] = 0;
        }
        for (int i = c1; i < c1 + c2; i++) {
            nums[i] = 1;
        }
        for (int i = c1 + c2; i < c1 + c2 + c3; i++) {
            nums[i] = 2;
        }
        System.out.println("After sorting: " + Arrays.toString(nums));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        List<Integer> secondRow = new ArrayList<>();
        secondRow.add(1);
        secondRow.add(1);
        list.add(firstRow);
        list.add(secondRow);
        return list;
    }
}
