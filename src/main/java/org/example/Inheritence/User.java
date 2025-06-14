package org.example.Inheritence;


public class User {
    String userName;
    String password;
    static final String role = "User";
    static int x;

    public void login() throws NullPointerException {
        System.out.println("User is logging in");

    }
    public void logout() {
        System.out.println("User is logging out");
    }
}