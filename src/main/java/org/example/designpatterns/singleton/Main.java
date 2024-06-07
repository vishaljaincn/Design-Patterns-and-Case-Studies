package org.example.designpatterns.singleton;

/**
 * The Main class to test the DatabaseConnection Singleton implementation.
 */
public class Main {
    /**
     * The main method to test the Singleton behavior.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Retrieve the Singleton instance of DatabaseConnection
        DatabaseConnection dbc1 = DatabaseConnection.getInstance();
        DatabaseConnection dbc2 = DatabaseConnection.getInstance();

        // Print debug message to check if the Singleton instance is working as expected
        System.out.println("DEBUG");
    }
}

// Singleton Class in multi-threading environment:
// 1. Early Initialization: Create the instance at class loading time.
// 2. Lazy Initialization:
//      1. Using synchronized keyword with getInstance() method - causes slow performance.
//      2. Using Double Check Locking - optimizes performance with thread safety.

/**
 * Assignment:
 * Create a Singleton class with double-checked locking and check if
 * that code works by creating multiple threads in the Client class.
 */

// Example of the Singleton class with double-checked locking
class SingletonExample {
    private static volatile SingletonExample instance;

    private SingletonExample() {
        // Private constructor to prevent instantiation
    }

    public static SingletonExample getInstance() {
        if (instance == null) { // Check-1: First check (without locking)
            synchronized (SingletonExample.class) {
                if (instance == null) { // Check-2: Second check (with locking)
                    instance = new SingletonExample();
                }
            }
        }
        return instance;
    }
}

// Example Client class to test the Singleton with multiple threads
class Client {
    public static void main(String[] args) {
        Runnable task = () -> {
            SingletonExample instance = SingletonExample.getInstance();
            System.out.println(instance);
        };

        // Create multiple threads to test the Singleton implementation
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
