package org.example.paralelStreams;

import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class ParallelStreamDemo {
    public static void main(String[] args) {
        List<Integer> list = IntStream.rangeClosed(1, 100000)
                .boxed()
                .toList();

        List<Double> list1 = DoubleStream.iterate(1.0, n -> n + 1.0)
                .limit(100000)
                .boxed()
                .toList();

        Integer a = 10;
        Integer b = 10;
        System.out.println(a.equals(b));
        System.out.println(a == b);
        System.out.println();
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
