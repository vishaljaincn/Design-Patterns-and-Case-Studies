package org.example.ExceptionHandling;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Custom {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println(a);

        try {
            readFile("abc.txt");
            throw new IOException();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }


//        try {
//            Pair pair = new Pair("Scaler", "Bangalore");
//            System.out.println(pair.first + " " + pair.second);
//            return;
//        } catch (RuntimeException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            System.out.println("Finally block");
//        }
        try{
            Pair pair = new Pair(null, null);
        }catch (Custom exception) {
            System.out.println(exception.getMessage());
        }
        //System.out.println(pair.first + " " + pair.second);
        System.out.println("Hello");
    }

    private static void readFile(String path) throws IOException {
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        fileReader.read();
    }
}