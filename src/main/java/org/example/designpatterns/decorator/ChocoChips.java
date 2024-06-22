package org.example.designpatterns.decorator;

/**
 * The ChocoChips class is a concrete decorator that adds choco chips to an existing
 * IceCream object. It implements the IceCream interface and modifies the behavior
 * of the wrapped IceCream object.
 */
public class ChocoChips implements IceCream {
    // Reference to an IceCream object to allow for decoration
    private IceCream iceCream;

    /**
     * Constructor for decorating an existing IceCream object with ChocoChips.
     *
     * @param iceCream the IceCream object to be decorated
     */
    public ChocoChips(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    /**
     * Returns the cost of the ice cream. If the ChocoChips is decorating another
     * IceCream object, it adds 5 to the cost of the decorated object. Otherwise,
     * it returns 0 to indicate invalid state.
     *
     * @return the cost of the ice cream, or 0 if the decorated object is null
     */
    @Override
    public int getCost() {
        if (iceCream != null) { // Always check for NullPointerException.
            return iceCream.getCost() + 5;
        }
        return 0; // Invalid state
    }

    /**
     * Returns the description of the ice cream. If the ChocoChips is decorating
     * another IceCream object, it appends " + Choco Chips" to the description of
     * the decorated object.
     *
     * @return a string description of the ice cream
     */
    @Override
    public String getDescription() {
        return iceCream.getDescription() + " + Choco Chips";
    }
}
