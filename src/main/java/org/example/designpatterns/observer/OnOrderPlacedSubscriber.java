package org.example.designpatterns.observer;

/**
 * Interface for subscribers that need to be notified when an order is placed.
 * This interface should be implemented by any class that wants to react to the event of an order being placed.
 */
public interface OnOrderPlacedSubscriber {
    /**
     * Method to be called when an order is placed.
     * Implementations of this method should define the actions to be taken when an order is placed.
     */
    void announceOrderPlaced();
}

/*
    - `public interface OnOrderPlacedSubscriber`: This defines an interface for subscribers that need to be notified when an order is placed.

    - `void announceOrderPlaced()`: This method is called when an order is placed. Classes implementing this interface should provide the logic for this method, defining the actions to be taken upon the order placement event.
*/
