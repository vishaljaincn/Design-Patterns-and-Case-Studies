package org.example;

public class RunnableDemo implements Runnable {
    private int value; // Storing the value as a class member

    // Constructor accepts the value that needs to be used inside run()
    public RunnableDemo(int value) {
        this.value = value;
    }

    @Override
    public void run() {
        System.out.println("Hello from RunnableDemo class");
        System.out.println("Value: " + value);
        value= 30; // This line will not compile because value is final
        // Here we can modify the class member, but not the original variable
    }
}

