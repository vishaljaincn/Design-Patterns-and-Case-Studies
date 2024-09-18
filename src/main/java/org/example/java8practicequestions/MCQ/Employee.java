package org.example.java8practicequestions.MCQ;

import java.util.*;
import java.util.stream.Collectors;

public class Employee {
    private Integer id;
    private String name;
    private String department;
    private Double salary;

    public Employee(Integer id, String name, String department, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "HR", 60000.0),
                new Employee(2, "Bob", "IT", 75000.0),
                new Employee(3, "Charlie", "IT", 80000.0),
                new Employee(4, "David", "HR", 65000.0)
        );

        Map<String, Double> map = employees.stream().filter(e -> e.getDepartment().equals("IT")).collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(map);
        OptionalDouble optionalDouble = employees.stream()
                .filter(e -> e.getDepartment().equals("IT"))
                .mapToDouble(Employee::getSalary)
                .average();
        System.out.println(optionalDouble);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(department, employee.department) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, department, salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
