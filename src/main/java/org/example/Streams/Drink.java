package org.example.Streams;


import java.util.TreeSet;

public class Drink implements Comparable {
    public String name;

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                '}';
    }

    public int compareTo(Object o) {
        return 0;  // This will always return 0, meaning all objects are considered equal.
    }

    public static void main(String[] args) {
        Drink one = new Drink();
        Drink two = new Drink();
        one.name = "Coffee";
        two.name = "Tea";

        TreeSet set = new TreeSet();
        set.add(one);
        set.add(two);
        System.out.println(set.size());
        for (Object o : set) {
            System.out.println(o.toString());
        }
    }
}
