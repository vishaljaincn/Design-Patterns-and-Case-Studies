package org.example.java8practicequestions;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Names = "sunny","anil","siva","john","kk","siva","sunny","john","siva","anil","siva","siva","sunny"
public class CountWords_Sapiens {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("sunny", "anil", "siva", "john", "kk", "siva", "sunny", "john", "siva", "anil", "siva", "siva", "sunny");

        // Count occurrences of each word
        Map<String, Long> wordCounts = list.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        // Sort by count in descending order and maintain insertion order
        Map<String, Long> sortedWordCounts = wordCounts.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> v1,
                        LinkedHashMap::new));

        System.out.println(sortedWordCounts);
    }
}
