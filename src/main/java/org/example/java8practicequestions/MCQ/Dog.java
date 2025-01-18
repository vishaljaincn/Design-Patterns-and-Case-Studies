package org.example.java8practicequestions.MCQ;

public class Dog extends Animal {
    int age = 90;


    void bark() throws Custom {
        System.out.println("Dog bark");
        throw new Custom("hello exception");
    }
}
