package org.example.ExceptionHandling;

public class Pair {
    String first;
    String second;

    Pair(String first, String second) throws Custom {
        if (first == null && second == null) {
            throw new Custom("First and Second attrs can't be NULL");
        }

        this.first = first;
        this.second = second;
    }
}