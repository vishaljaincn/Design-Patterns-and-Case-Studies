package org.example.java8practicequestions;

import java.util.Arrays;
import java.util.List;

class Sumofallnumberspresentinalist {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 5, 6, 7, 1, 2, 3);
        int sum = list.stream().reduce(0, (a, b) -> a + b);
        int sums = list.stream().mapToInt(i -> i).sum();
        System.out.println(sum);
        System.out.println(sums);
    }

}
