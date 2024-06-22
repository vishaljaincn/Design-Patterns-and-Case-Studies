package org.example.designpatterns.Flyweight;

/**
 * Interface for a registry that manages Flyweight objects.
 * This interface provides methods to add and retrieve Flyweight objects based on their intrinsic state.
 */
public interface FlyweightRegistry {

    /**
     * Adds a Flyweight object to the registry.
     *
     * @param flyweight The Flyweight object to be added.
     */
    void addFlyweight(UserIntrinsicState flyweight);

    /**
     * Retrieves a Flyweight object from the registry based on the email.
     *
     * @param email The email of the user whose Flyweight object is to be retrieved.
     * @return The Flyweight object associated with the given email.
     */
    UserIntrinsicState getFlyweight(String email);
}

/*
    - `public interface FlyweightRegistry`: This defines an interface for a registry that manages Flyweight objects.

    - `void addFlyweight(UserIntrinsicState flyweight)`: This method is used to add a Flyweight object to the registry. 
      The parameter `flyweight` is the Flyweight object to be added.

    - `UserIntrinsicState getFlyweight(String email)`: This method retrieves a Flyweight object from the registry based 
      on the email. The parameter `email` is the email of the user whose Flyweight object is to be retrieved. 
      The method returns the Flyweight object associated with the given email.
*/
