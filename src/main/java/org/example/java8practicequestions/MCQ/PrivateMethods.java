package org.example.java8practicequestions.MCQ;

class SuperClass {
    public static void main(String[] args) {
        // Creating an instance of SubClass but storing it in a SuperClass reference
        SuperClass superClass = new SubClass();

        // This will call the display method of SuperClass, not SubClass,
        // because private methods are not inherited, and hence not overridden.
        // The method here is resolved at compile time, so the SuperClass's private method is called.
        superClass.display();  // Output: "Private method in SuperClass"
    }

    // This is a private method, so it is not visible outside this class.
    // It cannot be overridden by any subclass.
    private void display() {
        System.out.println("Private method in SuperClass");
    }
}

class SubClass extends SuperClass {
    public static void main(String[] args) {
        SuperClass superClass = new SubClass();

        // This line is commented out because it would cause a compilation error.
        // The reason is that display() is private in SuperClass and not accessible outside of it,
        // so the compiler does not allow calling it here.
        //superClass.display();
    }

    // This is another private method, independent of the private method in SuperClass.
    // It does not override the method in SuperClass but hides it within this class.
    private void display() {
        System.out.println("Private method in SubClass");
    }
}
