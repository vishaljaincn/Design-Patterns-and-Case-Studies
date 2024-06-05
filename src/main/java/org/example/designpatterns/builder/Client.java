package org.example.designpatterns.builder;

public class Client {

    public static void main(String[] args) {
        // Create a Student object using the builder pattern with method chaining
        Student student = Student.getBuilder()
                .setName("Himanshu")
                .setAge(25)
                .setUnivName("XYZ")
                .setBatch("MWF Morning")
                .setGradYear(2022) // Ensure valid graduation year
                .build();

        System.out.println("Student Details:");
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("University: " + student.getUnivName());
        System.out.println("Batch: " + student.getBatch());
        System.out.println("Graduation Year: " + student.getGradYear());
    }
}

//Steps:-

/**
 *
 * 1. getBuilder() static method
 * 2. Make the Builder class static
 * 3. build method in Builder class.
 * 4. Make the setters of Builder class return Builder object.
 *
 *
 * Why we made setters return Builder object -> To support Method chaining.
 */
