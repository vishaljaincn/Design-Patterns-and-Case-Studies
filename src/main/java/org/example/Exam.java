package org.example;

public class Exam {
    public static void main(String[] args) {
        // Example 1: Demonstrating effectively final behavior in lambda
        int x = 10;

        // This lambda works because x is "effectively final" as long as we don't modify it
        Runnable lambdaRunnable = () -> {
            System.out.println("Hello from lambda");
            System.out.println("x value: " + x);
            // x = 20; // Uncommenting this line would cause a compilation error
            // Variables used in lambda must be final or effectively final
        };

        lambdaRunnable.run();

        // Example 2: Using our separate RunnableDemo class
        int y = 15;
        RunnableDemo classRunnable = new RunnableDemo(y);
        classRunnable.run();

        // We can change y here because it's just passed by value to the constructor
        y = 20;

        // Create a new instance with updated value
        RunnableDemo updatedRunnable = new RunnableDemo(y);
        updatedRunnable.run();

        System.out.println("Main method: y is now " + y);
    }
}
