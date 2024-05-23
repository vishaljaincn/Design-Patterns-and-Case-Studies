package org.example.Collections;

import java.util.TreeSet;

public class  TreeSetExample {
    public static Integer getJustLarger(TreeSet<Integer> treeSet, int data) {
        return treeSet.ceiling(data);
    }

    public static Integer getJustSmaller(TreeSet<Integer> treeSet, int data) {
        return treeSet.floor(data);
    }

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(10);
        treeSet.add(20);
        treeSet.add(30);
        treeSet.add(40);

        int data = 25;
        System.out.println("Just larger than " + data + ": " + getJustLarger(treeSet, data));
        System.out.println("Just smaller than " + data + ": " + getJustSmaller(treeSet, data));
    }
}
