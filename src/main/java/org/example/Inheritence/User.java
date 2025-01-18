package org.example.Inheritence;


public class User {
    String userName;
    String password;
    static final String role = "User";
    static int x;

    public void login() throws NullPointerException {
        System.out.println("User is logging in");

    }
}