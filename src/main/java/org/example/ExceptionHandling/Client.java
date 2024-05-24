package org.example.ExceptionHandling;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
       try{ readFile("abc.txt");}catch (IOException e){
           System.out.println(e.getMessage());
       }
        System.out.println("hi hello");
    }
    private static void readFile(String path) throws IOException {
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        fileReader.read();
    }
}
