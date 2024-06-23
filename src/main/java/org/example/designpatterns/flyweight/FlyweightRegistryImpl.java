package org.example.designpatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of the FlyweightRegistry interface.
 * This class manages a registry of Flyweight objects using a HashMap.
 */
public class FlyweightRegistryImpl implements FlyweightRegistry {
    // A map to store Flyweight objects with email as the key
    private Map<String, UserIntrinsicState> registry = new HashMap<>();

    /**
     * Adds a Flyweight object to the registry.
     *
     * @param flyweight The Flyweight object to be added.
     */
    @Override
    public void addFlyweight(UserIntrinsicState flyweight) {
        registry.put(flyweight.getEmail(), flyweight);
    }

    /**
     * Retrieves a Flyweight object from the registry based on the email.
     *
     * @param email The email of the user whose Flyweight object is to be retrieved.
     * @return The Flyweight object associated with the given email, or null if not found.
     */
    @Override
    public UserIntrinsicState getFlyweight(String email) {
        return registry.get(email);
    }
}

/*
    - `public class FlyweightRegistryImpl implements FlyweightRegistry`: This defines a class that implements the FlyweightRegistry interface.

    - `private Map<String, UserIntrinsicState> registry = new HashMap<>();`: This field is a map that stores Flyweight objects using the user's email as the key.

    - `public void addFlyweight(UserIntrinsicState flyweight)`: This method adds a Flyweight object to the registry. It uses the email from the Flyweight object as the key to store the object in the map.

    - `public UserIntrinsicState getFlyweight(String email)`: This method retrieves a Flyweight object from the registry based on the email. It returns the Flyweight object associated with the given email, or null if the email is not found in the registry.
*/
