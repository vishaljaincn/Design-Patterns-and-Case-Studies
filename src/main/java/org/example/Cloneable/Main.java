package org.example.Cloneable;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("New York");
        Person person1 = new Person("John", address);
        Person person2 = (Person) person1.clone();

        // Modifying the address in person2
        person2.address.city = "Los Angeles";

        System.out.println(person1.address.city); // Outputs: "New York" (Deep copy)
        System.out.println(person2.address.city); // Outputs: "Los Angeles"
    }
}
