package org.example.java8practicequestions;

public class OverLoadedMethods {

    // Overloaded methods with different parameter types
    public void print(Object o) {
        System.out.println("Object");
    }

    public void print(String s) {
        System.out.println("String");
    }

    public void print(Long l) {
        System.out.println("Long Wrapper");
    }

    public void print(long l) {
        System.out.println("Long Primitive");
    }

    public void print(int i) {
        System.out.println("Int");
    }

    public void print(Integer I) {
        System.out.println("Integer");
    }

    public void print(double d) {
        System.out.println("Double");
    }

    public void print(Float f) {
        System.out.println("Float");
    }

    public void print(char c) {
        System.out.println("Char");
    }

    public static void main(String[] args) {
        OverLoadedMethods obj = new OverLoadedMethods();

        // Scenario 1: Passing a String
        obj.print("Hello");
        // Calls print(String), as "Hello" is a String literal.

        // Scenario 2: Passing a long value
        obj.print(123L);
        // Calls print(Long Primitive), as 123L is a long literal.

        obj.print(Long.valueOf(123L));
        // Calls print(Long Wrapper), as Long.valueOf(123L) explicitly creates a Long object.

        // Scenario 3: Passing an int value
        obj.print(123);
        // Calls print(Int), as 123 is an int literal.

        // Scenario 4: Passing an Integer object
        obj.print(Integer.valueOf(123));
        // Calls print(Integer), as Integer.valueOf(123) explicitly creates an Integer object.

        // Scenario 5: Passing a double value
        obj.print(12.34);
        // Calls print(Double), as 12.34 is a double literal.

        // Scenario 6: Passing a Float object
        obj.print(Float.valueOf(12.34f));
        // Calls print(Float), as Float.valueOf creates a Float object.

        // Scenario 7: Passing a char value
        obj.print('A');
        // Calls print(Char), as 'A' is a char literal.

        // Scenario 8: Passing null
        // obj.print(null);
        // Causes ambiguity and leads to a compiler error because both print(String) and print(Any Wrapper Class)
        // And print(Object obj)
        // are equally specific and all of them can take null as a parameter input

        // Scenario 9: Passing a boxed Double
        obj.print(Double.valueOf(45.67));
        // Calls print(Object), as there is no overloaded method for Double, so it falls back to print(Object).

        // Scenario 10: Passing a char wrapped as Character
        obj.print(Character.valueOf('B'));
        // Calls print(Object), as there is no overloaded method for Character, so it falls back to print(Object).
    }
}
