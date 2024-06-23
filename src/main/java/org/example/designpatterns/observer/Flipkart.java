package org.example.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Flipkart acts as the publisher in the Observer design pattern.
 * It maintains a list of subscribers that need to be notified when an order is placed.
 */
public class Flipkart {
    // Singleton instance of Flipkart
    private static Flipkart instance = null;
    // List of subscribers to be notified when an order is placed
    private List<OnOrderPlacedSubscriber> onOrderPlacedSubscribers = new ArrayList<>();

    /**
     * Private constructor to prevent instantiation.
     * This ensures that Flipkart is a singleton.
     */
    private Flipkart() {
    }

    /**
     * Returns the singleton instance of Flipkart.
     * If the instance is null, it creates a new instance.
     *
     * @return the singleton instance of Flipkart
     */
    public static Flipkart getInstance() {
        if (instance == null) {
            instance = new Flipkart();
        }
        return instance;
    }

    /**
     * Registers a subscriber to be notified when an order is placed.
     *
     * @param onOrderPlacedSubscriber the subscriber to be registered
     */
    void registerSubscriber(OnOrderPlacedSubscriber onOrderPlacedSubscriber) {
        onOrderPlacedSubscribers.add(onOrderPlacedSubscriber);
    }

    /**
     * Unregisters a subscriber so it will no longer be notified when an order is placed.
     *
     * @param onOrderPlacedSubscriber the subscriber to be unregistered
     */
    void unRegisterSubscriber(OnOrderPlacedSubscriber onOrderPlacedSubscriber) {
        onOrderPlacedSubscribers.remove(onOrderPlacedSubscriber);
    }

    /**
     * Notifies all registered subscribers that an order has been placed.
     * This method is called when an order is placed and iterates over all subscribers,
     * calling their announceOrderPlaced method.
     */
    public void onOrderPlaced() {
        for (OnOrderPlacedSubscriber onOrderPlacedSubscriber : onOrderPlacedSubscribers) {
            onOrderPlacedSubscriber.announceOrderPlaced();
        }
    }
}

/*
    - `public class Flipkart`: This defines a class that acts as the publisher in the Observer design pattern.

    - `private static Flipkart instance = null`: This is the singleton instance of Flipkart.

    - `private List<OnOrderPlacedSubscriber> onOrderPlacedSubscribers = new ArrayList<>();`: This list maintains all subscribers that need to be notified when an order is placed.

    - `private Flipkart() {}`: The private constructor prevents external instantiation, ensuring that Flipkart is a singleton.

    - `public static Flipkart getInstance()`: This method returns the singleton instance of Flipkart. It creates the instance if it does not already exist.

    - `void registerSubscriber(OnOrderPlacedSubscriber onOrderPlacedSubscriber)`: This method adds a subscriber to the list of subscribers.

    - `void unRegisterSubscriber(OnOrderPlacedSubscriber onOrderPlacedSubscriber)`: This method removes a subscriber from the list of subscribers.

    - `public void onOrderPlaced()`: This method notifies all registered subscribers that an order has been placed. It iterates over all subscribers and calls their announceOrderPlaced method.
*/
