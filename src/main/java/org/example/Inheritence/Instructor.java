package org.example.Inheritence;


public class Instructor extends User {
    String batchName;
    double avgRating;

    private void login() {
        System.out.println("Instructor is logging in");
    }
}