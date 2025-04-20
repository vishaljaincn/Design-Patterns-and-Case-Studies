package org.example.java8practicequestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupWordsByTheirFirstCharacter {
    public static void main(String[] args) {
        List<String> list = List.of("Hi", "Hello", "Hey", "Apple", "Ant", "Ball", "Bat");

        // Group words by their first character
        Map<Character, List<String>> groupedWords = list
                .stream()
                .collect(Collectors.groupingBy(word -> word.charAt(0)));

        // Print the grouped words
        groupedWords.forEach((character, words) -> {
            System.out.println("Words starting with '" + character + "': " + words);
        });

    }
}