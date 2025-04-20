package org.example.java8practicequestions;

import java.util.*;
import java.util.stream.*;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class DuplicatKeysInAToMap {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Alice", 35)
        );

        Map<String, Integer> map = people.stream().collect(
                Collectors.toMap(
                        Person::getName,
                        Person::getAge,
                        (existingValue, newValue) -> {
                            System.out.println("Duplicate key found. Existing value: " + existingValue + ", New value: " + newValue);
                            return Math.max(existingValue, newValue); // Handle duplicate keys by keeping the maximum age
                        }
                )
        );

        System.out.println(map);
    }
}
