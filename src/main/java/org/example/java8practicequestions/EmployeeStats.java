package org.example.java8practicequestions;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class demonstrating various Java 8 stream operations on employee data
 */
public class EmployeeStats {
    /**
     * Employee class representing employee details
     */
    static class Employee {
        private String firstName;
        private String lastName;
        private String department;
        private int age;
        private String gender;
        private double salary;

        public Employee(String firstName, String lastName, String department, int age, String gender, double salary) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.department = department;
            this.age = age;
            this.gender = gender;
            this.salary = salary;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return getFirstName() + " " + getLastName() + " (" + getDepartment() + "), " +
                    getAge() + ", " + getGender() + ", " + getSalary();
        }

        /**
         * Returns the full name of the employee
         *
         * @return Full name (firstName + lastName)
         */
        public String getFullName() {
            return getFirstName() + " " + getLastName();
        }
    }

    public static void main(String[] args) {
        // Sample employee data
        List<Employee> employees = Arrays.asList(
                new Employee("John", "Doe", "IT", 30, "Male", 60000),
                new Employee("Jane", "Smith", "Finance", 28, "Female", 70000),
                new Employee("Alice", "Johnson", "IT", 26, "Female", 75000),
                new Employee("Bob", "Brown", "Finance", 32, "Male", 50000),
                new Employee("Tom", "Clark", "HR", 40, "Male", 65000),
                new Employee("John", "Doe", "IT", 35, "Male", 62000)
        );

        System.out.println("=== Using partitioningBy (via nameCountMap) to Find Duplicates and Uniques ===");
        Map<String, Long> nameCountMap = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getFullName,
                        Collectors.counting()
                ));

        Map<Boolean, List<Employee>> partitionedEmployees = employees.stream()
                .collect(Collectors.partitioningBy(
                        e -> nameCountMap.get(e.getFullName()) > 1
                ));

        List<Employee> duplicateEmployees = partitionedEmployees.get(true);
        List<Employee> uniqueEmployees = partitionedEmployees.get(false);

        System.out.println("Duplicates:");
        duplicateEmployees.forEach(System.out::println);

        System.out.println("\nNon-Duplicates:");
        uniqueEmployees.forEach(System.out::println);


        System.out.println("\n=== Using groupingBy to Find Duplicates and Uniques ===");
        Map<String, List<Employee>> groupedByName = employees.stream()
                .collect(Collectors.groupingBy(Employee::getFullName));

        List<Employee> duplicates = groupedByName.values()
                .stream()
                .filter(list -> list.size() > 1)
                .flatMap(List::stream)
                .toList();

        List<Employee> uniques = groupedByName.values()
                .stream()
                .filter(list -> list.size() == 1)
                .flatMap(List::stream)
                .toList();

        System.out.println("Duplicates:");
        duplicates.forEach(System.out::println);

        System.out.println("\nUniques:");
        uniques.forEach(System.out::println);


        System.out.println("\n=== Using partitioningBy (again, same logic) to Find Duplicates and Uniques ===");
        Map<Boolean, List<Employee>> partitioned = employees.stream()
                .collect(Collectors.partitioningBy(
                        e -> nameCountMap.get(e.getFullName()) > 1
                ));

        System.out.println("Duplicates (partitioning):");
        partitioned.get(true).forEach(System.out::println);

        System.out.println("\nUniques (partitioning):");
        partitioned.get(false).forEach(System.out::println);


        System.out.println("\n=== Department-wise Salary Stats ===");
        Map<String, DoubleSummaryStatistics> deptStats = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.summarizingDouble(Employee::getSalary)
                ));

        deptStats.forEach((dept, stats) -> {
            System.out.println("Department: " + dept);
            System.out.println("  Count   : " + stats.getCount());
            System.out.println("  Average : " + stats.getAverage());
            System.out.println("  Min     : " + stats.getMin());
            System.out.println("  Max     : " + stats.getMax());
            System.out.println();
        });
    }
}
