package org.example.Streams;


public class Yikes {
    public static void go(Long n) {
        System.out.println("Long ");
    }

    public static void go(Short n) {
        System.out.println("Short ");
    }

    public static void go(int n) {
        System.out.println("int ");
    }

    public static void main(String[] args) {
        short y = 6;
        long z = 7L;
        go(y);
        go(z);
    }
}