package org.example.java8practicequestions;

/**
 * This class demonstrates method overloading with the main method.
 * Note that only the standard main(String[] args) method is recognized by the JVM as the entry point.
 * Other overloaded main methods must be explicitly called from the standard main method.
 */
public class OverloadedMainMethods {

    // Standard main method - this is the only one that JVM will execute automatically
    public static void main(String[] args) {
        System.out.println("Standard main method with String[] args parameter executed");

        // Calling other overloaded main methods
        main();
        main(42);
        main(3.14);
        main(true);
        main('A');
    }

    // Overloaded main method with no parameters
    public static void main() {
        System.out.println("Overloaded main method with no parameters executed");
    }

    // Overloaded main method with int parameter
    public static void main(int number) {
        System.out.println("Overloaded main method with int parameter executed: " + number);
    }

    // Overloaded main method with double parameter
    public static void main(double value) {
        System.out.println("Overloaded main method with double parameter executed: " + value);
    }

    // Overloaded main method with boolean parameter
    public static void main(boolean flag) {
        System.out.println("Overloaded main method with boolean parameter executed: " + flag);
    }

    // Overloaded main method with char parameter
    public static void main(char character) {
        System.out.println("Overloaded main method with char parameter executed: " + character);
    }
}

