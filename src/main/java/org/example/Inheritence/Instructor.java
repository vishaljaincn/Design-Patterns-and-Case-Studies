package org.example.Inheritence;


public class Instructor extends User {
    String batchName;
    double avgRating;
    static String role = "Instructor";

    public Instructor(String userName, String password) {
        super(userName, password);
    }

    @Override
    public void login() throws RuntimeException {
        System.out.println("Instructor is logging in");
        int[] a = new int[5];
        User.x = 10;
        login();
    }
}