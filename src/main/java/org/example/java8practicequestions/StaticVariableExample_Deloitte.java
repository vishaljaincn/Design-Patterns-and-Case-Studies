package org.example.java8practicequestions;

/**
 * This program demonstrates the behavior of static variables in Java.
 * Static variables belong to the class rather than to instances of the class,
 * meaning all instances share the same static variable.
 */
public class StaticVariableExample_Deloitte {
    public static void main(String[] args) {
        // Create first instance of Base class
        Base a = new Base();
        // Set the static count variable to 5 using first instance
        a.count = 5;

        // Display the count using the first instance
        System.out.println("a.count = " + a.count);

        // Create second instance of Base class
        Base b = new Base();
        // Set the static count variable to 10 using second instance
        // This will change the value for ALL instances since count is static
        b.count = 10;

        // Both instances share the same static variable, so both will display 10
        System.out.println("a.count = " + a.count);
        System.out.println("b.count = " + b.count);

        // Note: It's better practice to access static variables through the class name: Base.count
    }
}

/**
 * A class with a static variable that is shared across all instances.
 */
class Base {
    // Static variables belong to the class, not to instances
    // All instances of Base will share this single count variable
    static int count;
}
