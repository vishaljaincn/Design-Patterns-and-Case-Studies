package org.example.designpatterns.observer;

/**
 * Client class to demonstrate the Observer design pattern.
 * It creates instances of services that need to be notified when an order is placed.
 */
public class Client {
    public static void main(String[] args) {
        // Get the singleton instance of Flipkart
        Flipkart flipkart = Flipkart.getInstance();

        // Create and register subscribers
        EmailService emailService = new EmailService();
        InventoryService inventoryService = new InventoryService();
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

        // Unregister EmailService before placing the order
        flipkart.unRegisterSubscriber(emailService);

        // Notify all subscribers that an order has been placed
        flipkart.onOrderPlaced();
    }
}

/*
    - `public class Client`: This defines a class that demonstrates the usage of the Observer design pattern by creating and registering subscribers and triggering an order placement event.

    - `public static void main(String[] args)`: The main method is the entry point of the application. It demonstrates the setup and usage of the Observer pattern.

    - `Flipkart flipkart = Flipkart.getInstance();`: This retrieves the singleton instance of Flipkart.

    - `EmailService emailService = new EmailService();`: This creates an instance of EmailService, which registers itself with Flipkart to receive order placement notifications.

    - `InventoryService inventoryService = new InventoryService();`: This creates an instance of InventoryService, which registers itself with Flipkart to receive order placement notifications.

    - `InvoiceGenerator invoiceGenerator = new InvoiceGenerator();`: This creates an instance of InvoiceGenerator, which registers itself with Flipkart to receive order placement notifications.

    - `flipkart.unRegisterSubscriber(emailService);`: This method call unregisters the EmailService, so it will not receive the order placement notification.

    - `flipkart.onOrderPlaced();`: This method call notifies all remaining registered subscribers that an order has been placed, triggering their respective `announceOrderPlaced` methods.
*/
