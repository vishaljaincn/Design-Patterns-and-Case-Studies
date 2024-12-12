package org.example.java8practicequestions;

import java.util.HashMap;
import java.util.Map;

public class Main{
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        String a = new String("a");
        String b = new String("a");
        map.put(a,1);
        System.out.println(map.get(b));
    }
}