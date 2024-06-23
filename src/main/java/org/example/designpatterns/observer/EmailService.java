package org.example.designpatterns.observer;

/**
 * EmailService is a subscriber that sends an email when an order is placed.
 * It implements the OnOrderPlacedSubscriber interface to react to the order placement event.
 */
public class EmailService implements OnOrderPlacedSubscriber {

    /**
     * Constructor that registers this subscriber with Flipkart.
     * When an instance of EmailService is created, it registers itself with Flipkart to receive order placement notifications.
     */
    EmailService() {
        Flipkart flipkart = Flipkart.getInstance();
        flipkart.registerSubscriber(this);
    }

    /**
     * Method called when an order is placed.
     * This method sends an email by printing a message to the console.
     */
    @Override
    public void announceOrderPlaced() {
        System.out.println("Sending Email");
    }
}

/*
    - `public class EmailService implements OnOrderPlacedSubscriber`: This defines a class that implements the OnOrderPlacedSubscriber interface. The class will react to order placement events by sending an email.

    - `EmailService()`: The constructor registers this instance with the Flipkart instance to receive notifications when an order is placed.

    - `Flipkart flipkart = Flipkart.getInstance()`: This retrieves the singleton instance of Flipkart.

    - `flipkart.registerSubscriber(this)`: This registers this instance as a subscriber to Flipkart's order placement notifications.

    - `public void announceOrderPlaced()`: This method is called when an order is placed. It prints a message to the console indicating that an email is being sent.
*/
