package org.example.designpatterns.decorator;

/**
 * The OrangeCone class is a concrete implementation of the IceCream interface.
 * It represents a basic ice cream cone with an orange flavor. This class serves
 * as a base component in the decorator pattern.
 */
public class OrangeCone implements IceCream {
    //OrangeCone will only behave like a base

    /**
     * Returns the description of the ice cream, which in this case is an "Orange Cone".
     *
     * @return a string description of the ice cream
     */
    @Override
    public String getDescription() {
        return "Orange Cone";
    }

    /**
     * Returns the cost of the orange cone ice cream.
     *
     * @return the cost of the orange cone ice cream
     */
    @Override
    public int getCost() {
        return 10;
    }
}
