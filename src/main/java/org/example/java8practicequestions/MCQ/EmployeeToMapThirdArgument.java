package org.example.java8practicequestions.MCQ;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class EmployeeToMapThirdArgument {
    private final int rollNo;
    private final String name;
    private final String address;
    private final int age;

    public EmployeeToMapThirdArgument(int rollNo, String name, String address, int age) {
        this.rollNo = rollNo;
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public static void main(String[] args) {
        List<EmployeeToMapThirdArgument> employees = Arrays.asList(
                new EmployeeToMapThirdArgument(1, "John", "123 Street", 30),
                new EmployeeToMapThirdArgument(2, "Jane", "456 Avenue", 25),
                new EmployeeToMapThirdArgument(3, "John", "789 Boulevard", 28),
                new EmployeeToMapThirdArgument(4, "Alice", "101 Road", 35)
        );

        // 1. Keep the first occurrence (Question 1)
        Map<String, Integer> nameToAgeMapFirst = employees.stream()
                .collect(Collectors.toMap(
                        EmployeeToMapThirdArgument::getName,
                        EmployeeToMapThirdArgument::getAge,
                        (existing, replacement) -> existing // keep the first occurrence
                ));
        System.out.println("Keep First Occurrence: " + nameToAgeMapFirst);

        // 2. Keep the last occurrence (Question 2)
        Map<String, Integer> nameToAgeMapLast = employees.stream()
                .collect(Collectors.toMap(
                        EmployeeToMapThirdArgument::getName,
                        EmployeeToMapThirdArgument::getAge,
                        (existing, replacement) -> replacement // keep the last occurrence
                ));
        System.out.println("Keep Last Occurrence: " + nameToAgeMapLast);

        // 3. Throw an exception on duplicates (Question 3)
        try {
            Map<String, Integer> nameToAgeMapException = employees.stream()
                    .collect(Collectors.toMap(
                            EmployeeToMapThirdArgument::getName,
                            EmployeeToMapThirdArgument::getAge,
                            (existing, replacement) -> {
                                throw new IllegalStateException("Duplicate key found: " + existing);
                            }
                    ));
            System.out.println("Throw Exception on Duplicates: " + nameToAgeMapException);
        } catch (IllegalStateException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // 4. Collect duplicates into a list (Question 4)
        Map<String, List<Integer>> nameToAgesMap = employees.stream()
                .collect(Collectors.groupingBy(
                        EmployeeToMapThirdArgument::getName,
                        Collectors.mapping(EmployeeToMapThirdArgument::getAge, Collectors.toList())
                ));
        System.out.println("Collect Duplicates into List: " + nameToAgesMap);

        // 5. Merge ages on duplicates (New Question)
        Map<String, Integer> nameToMergedAgeMap = employees.stream()
                .collect(Collectors.toMap(
                        EmployeeToMapThirdArgument::getName,
                        EmployeeToMapThirdArgument::getAge,
                        (existing, replacement) -> existing + replacement) // merge ages on duplicates
                );
        System.out.println("Merge Ages on Duplicates: " + nameToMergedAgeMap);

        // 6. Merge ages on duplicates (New Question)
        Map<String, Integer> nameToMergedAgeMaps = employees.stream()
                .collect(Collectors.toMap(
                        EmployeeToMapThirdArgument::getName,
                        EmployeeToMapThirdArgument::getAge,
                        Integer::sum) // merge ages on duplicates with method references
                );
        System.out.println("Merge Ages on Duplicates: " + nameToMergedAgeMaps);
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "EmployeeToMapThirdArgument{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeToMapThirdArgument employee = (EmployeeToMapThirdArgument) o;
        return rollNo == employee.rollNo &&
                age == employee.age &&
                Objects.equals(name, employee.name) &&
                Objects.equals(address, employee.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNo, name, address, age);
    }
}
