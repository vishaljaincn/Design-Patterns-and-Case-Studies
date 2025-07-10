package org.example.Inheritence;


public class User {
    String userName;
    String password;
    static final String role = "User";
    static int x;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;

    }

    public void login() throws NullPointerException {
        System.out.println("User is logging in");

    }

    public void logout() {
        System.out.println("User is logging out");
    }
}