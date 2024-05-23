package org.example.IntroToOOP;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Student obj1 = new Student(); // Object of Student class is created.
        obj1.name = "Vishnu";
        obj1.age = 25;
        obj1.batchName = "Morning batch";
        obj1.gender = "Male";
        Student obj2 = new Student(); // Object of Student class is created.
        obj1.name = "Vishnu";
        obj1.age = 25;
        obj1.batchName = "Morning batch";
        obj1.gender = "Male";
        System.out.println(Objects.hash(obj1));
        System.out.println(Objects.hash(obj2));
    }
}
