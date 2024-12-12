package org.example.Interface;


public class Client {
    public static void main(String[] args) {
        // Cat cat = new Cat();
        //Dog dog = new Dog();
//        cat.walk();
//        cat.run();
//        cat.eat();

        Animal animal = new Dog();
        animal.eat();
        animal.walk();
        System.out.println(animal instanceof Dog);
    }
}