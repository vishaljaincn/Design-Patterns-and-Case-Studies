package org.example.CustomOptional;

import java.util.NoSuchElementException;

/**
 * A custom implementation of Optional class to represent a value that may or may not be present.
 *
 * @param <T> the type of value
 */
public class MyOptional<T> {

    // The actual value stored, can be null if empty
    private final T value;

    /**
     * Private constructor to enforce usage of static factory methods.
     *
     * @param value the value to wrap
     */
    private MyOptional(T value) {
        this.value = value;
    }

    /**
     * Returns an empty Optional instance.
     *
     * @param <T> the type of the value
     * @return an empty MyOptional
     */
    public static <T> MyOptional<T> empty() {
        return new MyOptional<>(null);
    }

    /**
     * Returns an Optional with the specified non-null value.
     *
     * @param <T>   the type of the value
     * @param value the non-null value to wrap
     * @return a MyOptional with the value
     * @throws NullPointerException if value is null
     */
    public static <T> MyOptional<T> of(T value) {
        if (value == null) {
            throw new NullPointerException("Value cannot be null");
        }
        return new MyOptional<>(value);
    }

    /**
     * Returns an Optional describing the specified value, or empty if the value is null.
     *
     * @param <T>   the type of the value
     * @param value the possibly-null value to wrap
     * @return a MyOptional with the value or empty
     */
    public static <T> MyOptional<T> ofNullable(T value) {
        return new MyOptional<>(value);
    }

    /**
     * Returns true if the value is present (not null), false otherwise.
     *
     * @return whether a value is present
     */
    public boolean isPresent() {
        return value != null;
    }

    /**
     * Returns the value if present, otherwise throws NoSuchElementException.
     *
     * @return the non-null value
     * @throws NoSuchElementException if no value is present
     */
    public T get() {
        if (value == null) {
            throw new java.util.NoSuchElementException("No value present");
        }
        return value;
    }

    /**
     * Returns the value if present, otherwise returns the provided default.
     *
     * @param other the default value to return if no value is present
     * @return the value or the default
     */
    public T orElse(T other) {
        return value != null ? value : other;
    }

    /**
     * If a value is present, invoke the consumer with the value.
     *
     * @param consumer the action to be performed if a value is present
     */
    public void ifPresent(java.util.function.Consumer<? super T> consumer) {
        if (value != null) {
            consumer.accept(value);
        }
    }

    public static void main(String[] args) {
        MyOptional<String> name = MyOptional.ofNullable(null);
        MyOptional<String> name2 = new MyOptional<>("John Doe");
        name2.get();

        System.out.println(name.isPresent() ? "Name is present" : "Name is not present");

        name.ifPresent(value -> System.out.println("Hello, " + value));

        String greeting = name.orElse("Guest");
        System.out.println("Greeting: " + greeting);

        MyOptional<String> emptyName = MyOptional.empty();
        System.out.println(emptyName.orElse("Default Name"));
    }
}
