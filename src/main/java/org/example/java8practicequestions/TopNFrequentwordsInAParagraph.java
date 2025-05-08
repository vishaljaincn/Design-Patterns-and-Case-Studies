package org.example.java8practicequestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopNFrequentwordsInAParagraph {
    static Map<String, Long> topNFrequentwordsInAParagraph(String s, int n) {
        return Arrays.stream(s.toLowerCase().split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(n)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    }

    public static void main(String[] args) {
        String paragraph = "java is java and is of java is good of good and the best of best of everything";
        topNFrequentwordsInAParagraph(paragraph, 3)
                .forEach((word, count) -> System.out.println(word + ": " + count));
    }
}

