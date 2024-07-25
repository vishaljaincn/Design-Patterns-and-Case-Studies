package org.example.java8practicequestions;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Getter
class Employee123 {
    private int id;
    private String name;
    private String gender;
    private int age;

    public Employee123(int id, String name, String gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Streams2 {
    /**
     * Q1: Write a Java program using streams to print the average age of male and female employees separately.
     * Q2: Write a Java program using predicate chaining to filter and print the names and genders of employees who are males and older than 35 years.
     */
    public static void main(String[] args) {
        List<Employee123> employees = Arrays.asList(
                new Employee123(1, "Alice", "Female", 30),
                new Employee123(2, "Bob", "Male", 25),
                new Employee123(3, "Charlie", "Male", 35),
                new Employee123(4, "Diana", "Female", 40),
                new Employee123(5, "Eve", "Female", 28),
                new Employee123(6, "Sam", "Male", 45),
                new Employee123(7, "Bobby Deol", "Male", 38),
                new Employee123(8, "Charles", "Male", 31));

        // Q1: Print the average age of male and female employees
        Map<String, Double> averageAges = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee123::getGender,
                        Collectors.averagingInt(Employee123::getAge)));

        averageAges.forEach((gender, avgAge) ->
                System.out.println("Gender: " + gender + " | Average Age: " + avgAge));

        // Q2: Predicate chaining used in filter operation
        Predicate<Employee123> isMale = e -> e.getGender().equals("Male");
        Predicate<Employee123> isOlderThan35 = e -> e.getAge() > 35;
        Predicate<Employee123> combinedPredicate = isMale.and(isOlderThan35);

        // Q2: Print the names and genders of employees who are males and older than 35
        employees.stream()
                .filter(combinedPredicate)
                .forEach(e ->
                        System.out.println("Name: " + e.getName() + " | Gender: " + e.getGender()));

        // Q2: Print the names and genders of employees who are males and older than 35 using just filter
        employees.stream()
                .filter(e -> e.getGender().equals("Male") && e.getAge() > 35)
                .forEach(e ->
                        System.out.println("Name: " + e.getName() + " | Gender: " + e.getGender()));

        /*
        Best Practice:
For simple conditions: Directly use the filter operation with combined conditions as shown above.
For complex conditions or reusable predicates: Use predicate chaining, which can enhance readability and reusability.
         */
    }
}
