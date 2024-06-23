package org.example.designpatterns.observer;

/**
 * InventoryService is a subscriber that notifies the inventory system when an order is placed.
 * It implements the OnOrderPlacedSubscriber interface to react to the order placement event.
 */
public class InventoryService implements OnOrderPlacedSubscriber {

    /**
     * Constructor that registers this subscriber with Flipkart.
     * When an instance of InventoryService is created, it registers itself with Flipkart to receive order placement notifications.
     */
    InventoryService() {
        Flipkart flipkart = Flipkart.getInstance();
        flipkart.registerSubscriber(this);
    }

    /**
     * Method called when an order is placed.
     * This method notifies the inventory system by printing a message to the console.
     */
    @Override
    public void announceOrderPlaced() {
        System.out.println("Notifying Inventory");
    }
}

/*
    - `public class InventoryService implements OnOrderPlacedSubscriber`: This defines a class that implements the OnOrderPlacedSubscriber interface. The class will react to order placement events by notifying the inventory system.

    - `InventoryService()`: The constructor registers this instance with the Flipkart instance to receive notifications when an order is placed.

    - `Flipkart flipkart = Flipkart.getInstance()`: This retrieves the singleton instance of Flipkart.

    - `flipkart.registerSubscriber(this)`: This registers this instance as a subscriber to Flipkart's order placement notifications.

    - `public void announceOrderPlaced()`: This method is called when an order is placed. It prints a message to the console indicating that the inventory system is being notified.
*/
