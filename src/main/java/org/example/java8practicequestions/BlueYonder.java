package org.example.java8practicequestions;

import java.util.*;
import java.util.stream.Collectors;

/*
There is a student class with instance variables such as id, department, rank, name, etc,
now you need to utilize the Java 8 streams method and find the highest rank student in each
department and then ask me to print the result using Java 8
 */
// Student class definition
class Studentt {
    private int id;
    private String name;
    private String department;
    private int rank;

    // Constructor
    public Studentt(int id, String name, String department, int rank) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.rank = rank;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', department='" + department + "', rank=" + rank + "}";
    }
}

public class BlueYonder {
    public static void main(String[] args) {
        // List of students
        List<Studentt> students = Arrays.asList(
                new Studentt(1, "Alice", "CS", 4),
                new Studentt(2, "Bob", "CS", 1),
                new Studentt(3, "Charlie", "EC", 2),
                new Studentt(4, "David", "EC", 3),
                new Studentt(5, "Eve", "ME", 7),
                new Studentt(6, "Frank", "ME", 3)
        );

        // Finding the highest rank student in each department
        Map<String, Optional<Studentt>> topStudentsByDept = students.stream()
                .collect(Collectors.groupingBy(
                        Studentt::getDepartment,
                        Collectors.maxBy(Comparator.comparing(Studentt::getRank))
                ));

        // Printing the result
        topStudentsByDept.forEach((department, student) ->
                System.out.println("Department: " + department + ", Top Student: " + student.orElse(null))
        );
    }
}
