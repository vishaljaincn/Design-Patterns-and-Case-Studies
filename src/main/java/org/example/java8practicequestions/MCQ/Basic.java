package org.example.java8practicequestions.MCQ;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Basic {
    public static void main(String[] args) {

        // Creating example lists
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        Iterator<Integer> iterator = list1.iterator();
        list1.add(4);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
