package org.example.java8practicequestions;

import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String firstName;
    private String lastName;
    private int deptId;
    private int rollNumber;  // Added rollNumber field

    // Constructor
    public Student(String firstName, String lastName, int deptId, int rollNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.deptId = deptId;
        this.rollNumber = rollNumber;  // Initialize rollNumber
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public int getDeptId() {
        return deptId;
    }

    public int getRollNumber() {
        return rollNumber;  // Getter for rollNumber
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollNumber == student.rollNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(rollNumber);
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", deptId=" + deptId +
                ", rollNumber=" + rollNumber +  // Include rollNumber in toString
                '}';
    }
}

public class AccentureInterview {
    public static void main(String[] args) {
        // Sample list of students
        List<Student> students = Arrays.asList(
                new Student("Alice", "Smith", 4, 101),
                new Student("Aob", "Johnson", 4, 102),
                new Student("Alex", "Williams", 3, 103),
                new Student("Alex", "Williams", 5, 103),
                new Student("Alex", "Williams", 6, 103),
                new Student("Alex", "Williams", 7, 103),
                new Student("Alex", "Williams", 2, 103),
                new Student("Aaron", "Brown", 3, 104),
                new Student("John", "Davis", 2, 105),
                new Student("Anna", "Garcia", 1, 106)
        );


        Student students2 = new Student("Alice", "Smith", 4, 101);
        System.out.println(students2.getClass());

        // Filtering students whose first name starts with "A" and grouping them by department ID using method references
        Map<Integer, List<Student>> groupedStudents1 = students.stream()
                .filter(student -> student.getFirstName().startsWith("A"))
                .collect(Collectors.groupingBy(Student::getDeptId, LinkedHashMap::new, Collectors.toList()));

        // Printing the grouped students without using method references
        groupedStudents1.forEach((deptId, studentList) -> {
            System.out.println("Department ID: " + deptId);
            studentList.forEach(System.out::println);
        });

        // Question: Find the third largest element in a list of integers.

        // Creating a list of integers
        List<Integer> list = Arrays.asList(10, 5, 4, 3, 17, 58, 97, 43);

        // Using stream to sort the list in descending order
        // Skip the first two elements and then find the first element (which will be the third largest)
        Integer ans = list.stream()
                .sorted((i, j) -> j - i)  // Sorting in descending order
                .skip(2)                  // Skipping the first two largest elements
                .findFirst()              // Getting the third largest element
                .get();                   // Extracting the value

        // Print the third largest element
        System.out.println(ans); // Output will be 43

    }
}
