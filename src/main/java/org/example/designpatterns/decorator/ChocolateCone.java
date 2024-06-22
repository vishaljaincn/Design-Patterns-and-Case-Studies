package org.example.designpatterns.decorator;

/**
 * The ChocolateCone class is a concrete implementation of the IceCream interface.
 * It represents an ice cream cone with chocolate flavor and can serve as both a
 * base component and a decorator in the decorator pattern.
 */
public class ChocolateCone implements IceCream {
    // Reference to an IceCream object to allow for decoration
    private IceCream iceCream;

    /**
     * Default constructor for creating a plain ChocolateCone without decoration.
     */
    public ChocolateCone() {}

    /**
     * Constructor for decorating an existing IceCream object with a ChocolateCone.
     *
     * @param iceCream the IceCream object to be decorated
     */
    public ChocolateCone(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    /**
     * Returns the description of the ice cream. If the ChocolateCone is decorating another
     * IceCream object, it appends " + Chocolate Cone" to the description of the decorated object.
     * Otherwise, it returns "Chocolate Cone".
     *
     * @return a string description of the ice cream
     */
    @Override
    public String getDescription() {
        if (iceCream != null) {
            return iceCream.getDescription() + " + Chocolate Cone";
        }
        return "Chocolate Cone";
    }

    /**
     * Returns the cost of the ice cream. If the ChocolateCone is decorating another IceCream object,
     * it adds 30 to the cost of the decorated object. Otherwise, it returns 30.
     *
     * @return the cost of the ice cream
     */
    @Override
    public int getCost() {
        if (iceCream != null) {
            return iceCream.getCost() + 30;
        }
        return 30;
    }
}
