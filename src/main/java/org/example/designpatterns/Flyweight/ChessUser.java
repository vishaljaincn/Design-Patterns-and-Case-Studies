package org.example.designpatterns.Flyweight;

/**
 * Represents a user in a chess game.
 */
public class ChessUser {
    // The name of the user
    private String name;

    // The age of the user
    private int age;

    // The gender of the user
    private String gender;

    // The email address of the user
    private String email;

    // The phone number of the user
    private String phoneNumber;

    // The colour assigned to the user for the chess game (e.g., White or Black)
    private Colour colour;

    // The current game winning streak of the user
    private int currentGameStreak;

    // A photo of the user
    private Byte[] photo;

    // Getters and Setters for the fields could be added here for accessing and modifying the field values
}
