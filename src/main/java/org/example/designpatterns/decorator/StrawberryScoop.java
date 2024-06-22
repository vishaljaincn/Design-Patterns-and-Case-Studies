package org.example.designpatterns.decorator;

/**
 * The StrawberryScoop class is a concrete decorator that adds a strawberry scoop
 * to an existing IceCream object. It implements the IceCream interface and modifies
 * the behavior of the wrapped IceCream object.
 */
public class StrawberryScoop implements IceCream {
    // Reference to an IceCream object to allow for decoration
    private IceCream iceCream;

    /**
     * Constructor for decorating an existing IceCream object with a StrawberryScoop.
     *
     * @param iceCream the IceCream object to be decorated
     */
    public StrawberryScoop(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    /**
     * Returns the description of the ice cream. It appends " + Strawberry Scoop"
     * to the description of the decorated IceCream object.
     *
     * @return a string description of the ice cream
     */
    @Override
    public String getDescription() {
        return iceCream.getDescription() + " + Strawberry Scoop";
    }

    /**
     * Returns the cost of the ice cream. It adds 30 to the cost of the decorated
     * IceCream object.
     *
     * @return the cost of the ice cream
     */
    @Override
    public int getCost() {
        return iceCream.getCost() + 30;
    }
}
