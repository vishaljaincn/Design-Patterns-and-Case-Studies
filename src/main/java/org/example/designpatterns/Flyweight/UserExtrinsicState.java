package org.example.designpatterns.Flyweight;

/**
 * Represents the extrinsic state of a user in the Flyweight design pattern.
 * This class is annotated with @ExtrinsicState to indicate that its state is passed from the client
 * to the Flyweight object and is not shared.
 */
@ExtrinsicState
public class UserExtrinsicState {
    // The colour assigned to the user for the chess game (e.g., BLACK or WHITE)
    private Colour colour;

    // The current game winning streak of the user
    private int currentGameStreak;

    // Reference to the user's intrinsic state
    private UserIntrinsicState user;
}

/*
    - `@ExtrinsicState`: This annotation indicates that the class contains extrinsic state, which is the part of the state that is passed from the client to the Flyweight object and is not shared.
    
    - `private Colour colour`: This field stores the colour assigned to the user for the chess game.
    
    - `private int currentGameStreak`: This field stores the current game winning streak of the user.
    
    - `private UserIntrinsicState user`: This field stores a reference to the user's intrinsic state.
*/
