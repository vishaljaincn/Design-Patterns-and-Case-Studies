package org.example.Collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("India");
        set.add("USA");
        set.add("China");
        set.add("UAE");
        set.add("UK");

        for (String str : set) {
            System.out.println(str);
        }
        HashMap map = new HashMap();
        int x = 5;
        int y = 6;
        System.out.println(Objects.hash(x, y));
        int x1 = 5;
        int y1 = 6;
        System.out.println(Objects.hash(x, y));
    }
}