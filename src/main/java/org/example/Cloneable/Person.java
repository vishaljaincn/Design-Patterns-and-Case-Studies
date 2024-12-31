package org.example.Cloneable;

public class Person implements Cloneable {
    private String name;
    Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person cloned = (Person) super.clone();
        cloned.address = (Address) this.address.clone(); // Deep copy
        return cloned;
    }
}
