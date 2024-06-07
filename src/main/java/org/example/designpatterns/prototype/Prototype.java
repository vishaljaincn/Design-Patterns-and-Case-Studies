package org.example.designpatterns.prototype;

/**
 * The Prototype interface defines a method for cloning objects.
 * Classes that implement this interface can produce a copy of themselves.
 * This is useful in scenarios where creating a new instance is either
 * expensive or complicated, and cloning an existing instance is more efficient.
 *
 * @param <T> the type of object that can be cloned
 */
public interface Prototype<T> {

    /**
     * Creates and returns a copy of the object.
     *
     * @return a clone of the object implementing this interface
     */
    T clone();
}
