package org.example.designpatterns.decorator;

/**
 * The IceCream interface defines the methods that concrete ice cream components
 * and decorators must implement. It provides a way to get the cost and description
 * of an ice cream.
 */
public interface IceCream {
    /**
     * Returns the cost of the ice cream.
     *
     * @return the cost of the ice cream
     */
    int getCost();

    /**
     * Returns the description of the ice cream.
     *
     * @return the description of the ice cream
     */
    String getDescription();
}
