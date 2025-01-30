package org.example.Interface;


public class Client {
    public static void main(String[] args) {
        // Cat cat = new Cat();
        //Dog dog = new Dog();
//        cat.walk();
//        cat.run();
//        cat.eat();
//
//        Animal animal = new Dog();
//        animal.eat();
//        animal.walk();
//      //System.out.println(animal instanceof Dog);
        Hero hero = new Hero() {
            @Override
            public void sing1() {
                System.out.println("Sing1");
                sing2();
            }

            @Override
            public void dance() {

            }

            public void sing2() {
                System.out.println("Sing2");
            }
        };
        hero.sing1();

        Fun fun = new Fun() {
        };

    }
}