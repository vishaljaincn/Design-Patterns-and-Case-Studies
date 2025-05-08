package org.example.sealedclass;

// Sealed class declaration
sealed class Shape permits Circle, Rectangle, Triangle {
    void draw() {
    }
}

// Permitted subclass: A final class (cannot be extended further)
final class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a Circle");
    }
}

// Permitted subclass: Another sealed class (can define its own permitted subclasses)
sealed class Rectangle extends Shape permits Square {
    @Override
    void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

// Permitted subclass: A non-sealed class (can be extended by any other class)
non-sealed class Triangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a Triangle");
    }
}

// Subclass of Rectangle (since Rectangle is sealed and allows it)
final class Square extends Rectangle {
    @Override
    void draw() {
        System.out.println("Drawing a Square");
    }
}

// Main class to test sealed classes
public class SealedClassExample {
    public static void main(String[] args) {
        Shape s1 = new Circle();
        Shape s2 = new Rectangle();
        Shape s3 = new Triangle();
        Shape s4 = new Square();

        s1.draw();
        s2.draw();
        s3.draw();
        s4.draw();
    }
}
