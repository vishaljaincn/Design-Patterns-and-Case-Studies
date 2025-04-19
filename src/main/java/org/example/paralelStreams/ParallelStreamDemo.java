package org.example.paralelStreams;

import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamDemo {
    public static void main(String[] args) {
        List<Integer> list = IntStream.rangeClosed(1, 100000)
                .boxed()
                .toList();

        System.out.println("=== Using findFirst() ===");
        Integer first = list.parallelStream()
                .peek(i -> System.out.println("Processing " + i + " on thread " + Thread.currentThread().getName()))
                .findFirst()
                .orElse(-1);
        System.out.println("Result from findFirst(): " + first);

        System.out.println("\n=== Using findAny() ===");
        Integer any = list.parallelStream()
                .findAny()
                .orElse(-1);
        System.out.println("Result from findAny(): " + any);

        System.out.println("=== Using findFirst() ===");
        Integer first1 = list.stream()
                .findFirst()
                .orElse(-1);
        System.out.println("Result from findFirst(): " + first1);

        System.out.println("\n=== Using findAny() ===");
        Integer any1 = list.stream()
                .findAny()
                .orElse(-1);
        System.out.println("Result from findAny(): " + any1);
    }
}
