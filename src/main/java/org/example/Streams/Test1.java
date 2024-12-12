package org.example.Streams;

interface A {
    int aMethod(String s);
}

public class Test1 {
    void Test1() {
        System.out.println("hi");
    }

    public static void foo(Integer i) {
        System.out.println("foo(Integer)");
    }

    public static void main(String[] args) {
        // Valid lambda expression: takes a String and returns a constant integer.
        //A a = v -> v.length();
        // A x = y -> {return y;};
        //System.out.println(a.aMethod("hello"));
        // A s = "2" -> Integer.parseInt(s);
        //A b = (String s) -> 1;
        // Test the lambda expression
        // System.out.println(b.aMethod("test")); // Output: 1
        Test1 test1 = new Test1();
        test1.Test1();
    }
}
