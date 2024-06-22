package org.example.designpatterns.decorator;

/**
 * The Client class demonstrates the use of the decorator pattern by creating
 * an IceCream object and decorating it with various toppings and cones.
 */
public class Client {
    public static void main(String[] args) {
        // Creating an IceCream object with multiple layers of decoration
        IceCream iceCream =
                new ChocoChips( // Adding ChocoChips
                        new StrawberryScoop( // Adding StrawberryScoop
                                new ChocolateCone( // Using ChocolateCone
                                        new ChocoChips( // Adding ChocoChips again
                                                new OrangeCone() // Starting with OrangeCone
                                        )
                                )
                        )
                );

        // Printing the description and cost of the decorated IceCream object
        System.out.println(iceCream.getDescription());
        System.out.println(iceCream.getCost());

        // Creating the IceCream object with multiple layers of decoration in a different style
        IceCream iceCreams = new OrangeCone(); // Starting with OrangeCone
        iceCreams = new ChocoChips(iceCreams); // Adding ChocoChips
        iceCreams = new ChocolateCone(iceCreams); // Using ChocolateCone
        iceCreams = new StrawberryScoop(iceCreams); // Adding StrawberryScoop
        iceCreams = new ChocoChips(iceCreams); // Adding ChocoChips again

        // Printing the description and cost of the decorated IceCream object
        System.out.println(iceCreams.getDescription());
        System.out.println(iceCreams.getCost());

        // Additional examples to show different ways to invoke the decorators

        // Simple OrangeCone
        IceCream simpleIceCream = new OrangeCone();
        System.out.println(simpleIceCream.getDescription());
        System.out.println(simpleIceCream.getCost());

        // OrangeCone with one layer of ChocoChips
        IceCream chocoChipsIceCream = new ChocoChips(new OrangeCone());
        System.out.println(chocoChipsIceCream.getDescription());
        System.out.println(chocoChipsIceCream.getCost());

        // OrangeCone with ChocolateCone
        IceCream chocolateConeIceCream = new ChocolateCone(new OrangeCone());
        System.out.println(chocolateConeIceCream.getDescription());
        System.out.println(chocolateConeIceCream.getCost());

        // ChocolateCone with VanillaScoop
        IceCream vanillaChocolateConeIceCream = new VanillaScoop(new ChocolateCone(new OrangeCone()));
        System.out.println(vanillaChocolateConeIceCream.getDescription());
        System.out.println(vanillaChocolateConeIceCream.getCost());

        // Complex example with multiple decorations
        IceCream complexIceCream = new VanillaScoop( // Adding VanillaScoop
                new ChocoChips( // Adding ChocoChips
                        new StrawberryScoop( // Adding StrawberryScoop
                                new ChocolateCone( // Using ChocolateCone
                                        new OrangeCone() // Starting with OrangeCone
                                )
                        )
                )
        );
        System.out.println(complexIceCream.getDescription());
        System.out.println(complexIceCream.getCost());
    }
}
