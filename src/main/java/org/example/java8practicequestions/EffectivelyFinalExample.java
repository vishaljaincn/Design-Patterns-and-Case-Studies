package org.example.java8practicequestions;

public class EffectivelyFinalExample {
    public static void main(String[] args) {
        int effectivelyFinalVar = 10;

        // Lambda
        Runnable lambda = () -> System.out.println("Lambda: " + effectivelyFinalVar);

        // Anonymous Inner Class
        Runnable anonClass = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Inner Class: " + effectivelyFinalVar);
            }
        };

        lambda.run();
        anonClass.run();

        // Uncommenting this line would cause a compilation error
        // effectivelyFinalVar = 20;
    }
}
