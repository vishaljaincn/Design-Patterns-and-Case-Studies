package org.example.designpatterns.decorator;

/**
 * The VanillaScoop class is a concrete decorator that adds a vanilla scoop
 * to an existing IceCream object. It implements the IceCream interface and modifies
 * the behavior of the wrapped IceCream object.
 */
public class VanillaScoop implements IceCream {
    // Reference to an IceCream object to allow for decoration
    private IceCream iceCream;

    /**
     * Constructor for decorating an existing IceCream object with a VanillaScoop.
     *
     * @param iceCream the IceCream object to be decorated
     */
    public VanillaScoop(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    /**
     * Returns the description of the ice cream. It appends " + Vanilla Scoop"
     * to the description of the decorated IceCream object.
     *
     * @return a string description of the ice cream
     */
    @Override
    public String getDescription() {
        return iceCream.getDescription() + " + Vanilla Scoop";
    }

    /**
     * Returns the cost of the ice cream. It adds 40 to the cost of the decorated
     * IceCream object.
     *
     * @return the cost of the ice cream
     */
    @Override
    public int getCost() {
        return iceCream.getCost() + 40;
    }
}
