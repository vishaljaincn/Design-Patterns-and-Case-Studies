package org.example.designpatterns.flyweight;

import lombok.Getter;

/**
 * Represents the intrinsic state of a user in the Flyweight design pattern.
 * This class is annotated with @IntrinsicState to indicate that its state is shared between different Flyweight objects.
 * The Lombok @Getter annotation is used to automatically generate getter methods for all fields.
 */
@IntrinsicState
@Getter
public class UserIntrinsicState {
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

    // A photo of the user
    private Byte[] photo;
}

/*
    - `@IntrinsicState`: This annotation indicates that the class contains intrinsic state, which is the part of the state that is shared between different Flyweight objects.

    - `@Getter`: This Lombok annotation automatically generates getter methods for all fields in the class, reducing boilerplate code.

    - `private String name`: This field stores the name of the user.

    - `private int age`: This field stores the age of the user.

    - `private String gender`: This field stores the gender of the user.

    - `private String email`: This field stores the email address of the user.

    - `private String phoneNumber`: This field stores the phone number of the user.

    - `private Byte[] photo`: This field stores a photo of the user.
*/
