package org.example.designpatterns.observer;

/**
 * InvoiceGenerator is a subscriber that generates an invoice when an order is placed.
 * It implements the OnOrderPlacedSubscriber interface to react to the order placement event.
 */
public class InvoiceGenerator implements OnOrderPlacedSubscriber {

    /**
     * Constructor that registers this subscriber with Flipkart.
     * When an instance of InvoiceGenerator is created, it registers itself with Flipkart to receive order placement notifications.
     */
    InvoiceGenerator() {
        Flipkart flipkart = Flipkart.getInstance();
        flipkart.registerSubscriber(this);
    }

    /**
     * Method called when an order is placed.
     * This method generates an invoice by printing a message to the console.
     */
    @Override
    public void announceOrderPlaced() {
        System.out.println("Generating invoice");
    }
}

/*
    - `public class InvoiceGenerator implements OnOrderPlacedSubscriber`: This defines a class that implements the OnOrderPlacedSubscriber interface. The class will react to order placement events by generating an invoice.

    - `InvoiceGenerator()`: The constructor registers this instance with the Flipkart instance to receive notifications when an order is placed.

    - `Flipkart flipkart = Flipkart.getInstance()`: This retrieves the singleton instance of Flipkart.

    - `flipkart.registerSubscriber(this)`: This registers this instance as a subscriber to Flipkart's order placement notifications.

    - `public void announceOrderPlaced()`:
*/