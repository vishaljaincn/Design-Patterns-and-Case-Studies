package org.example.java8practicequestions;

import java.util.Arrays;
import java.util.List;

//[0,1,0,1,0,1,1,1,1,1,1,1,0,1,1,1,0,0,0]
public class SortArrayContainingOnlyZeroesAndOnes_Sapiens {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0);
        int zeroCount = 0;
        int oneCount = 0;
        System.out.println(list);
        for (Integer integer : list) {
            if (integer == 0) {
                zeroCount++;
            } else {
                oneCount++;
            }
        }
        for (int i = 0; i < zeroCount; i++) {
            list.set(i, 0);
        }
        for (int i = zeroCount; i < zeroCount + oneCount; i++) {
            list.set(i, 1);
        }
        System.out.println(list);
    }
}

