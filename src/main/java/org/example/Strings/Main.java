package org.example.Strings;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        int a=10/0;
        System.out.println(a);
        list.add("A");
        list.add("B");
        list.add("C");

        // Single thread, but still modifying during iteration
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            if (value.equals("B")) {
                list.remove(value);
                list.add("vishal");
                list.add("vishal1");
            }
        }
    }
}
