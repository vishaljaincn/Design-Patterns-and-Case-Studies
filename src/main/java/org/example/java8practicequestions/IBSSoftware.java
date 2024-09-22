package org.example.java8practicequestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Question: Given a list of employees, each belonging to a specific department, write a Java 8 program
 * to find the department with the maximum number of employees. Use streams and lambda expressions to process the data.
 */

class IBSSoftware {
    private final String name;
    private final String department;

    public IBSSoftware(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public static void main(String[] args) {
        List<IBSSoftware> employees = Arrays.asList(
                new IBSSoftware("John", "HR"),
                new IBSSoftware("Alice", "Engineering"),
                new IBSSoftware("Bob", "Engineering"),
                new IBSSoftware("Mike", "HR"),
                new IBSSoftware("Steve", "Engineering"),
                new IBSSoftware("Jessica", "Finance")
        );

        // Finding the department with the maximum number of employees
        String departmentWithMaxEmployees = employees.stream()
                .collect(Collectors.groupingBy(IBSSoftware::getDepartment, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("No department found");

        System.out.println("Department with the maximum number of employees: " + departmentWithMaxEmployees);
    }
}