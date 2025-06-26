package org.example.java8practicequestions;

import java.util.*;
import java.util.stream.Stream;

/**
 * Employee class to demonstrate Stream operations
 */
class Employee12 {
    // Fields
    private int id;
    private String name;
    private int salary;

    // Constructor
    public Employee12(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    // Object methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Employee12 that = (Employee12) o;
        return id == that.id && salary == that.salary && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary);
    }

    @Override
    public String toString() {
        return "Employee12{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

/**
 * This class demonstrates various Stream API operations in Java 8+
 * with sorting, filtering, mapping, and flattening examples.
 */
class Stream1 {
    public static void main(String[] args) {
        // Sample data - Employee list
        ArrayList<Employee12> employees = new ArrayList<>();
        employees.add(new Employee12(1, "Thejas", 30000));
        employees.add(new Employee12(1, "Ranjith", 10000));
        employees.add(new Employee12(1, "Shreyas", 40000));
        employees.add(new Employee12(1, "Vishal", 20000));
        employees.add(new Employee12(1, "Gautam", 20000));

        // ------------ EMPLOYEE SORTING EXAMPLES ------------

        System.out.println("1. SORTING EMPLOYEES BY SALARY AND NAME (ASCENDING):");
        // Sort employees by salary (ascending) and then by name if salaries are equal
        List<Employee12> empList = employees.stream()
                .peek(System.out::println) // Debug: print each employee before sorting
                .sorted(Comparator.comparing(Employee12::getSalary)
                        .thenComparing(Employee12::getName))
                .toList();

        System.out.println("\nResult after sorting:");
        empList.forEach(i -> System.out.println(i.getName() + " - $" + i.getSalary()));

        System.out.println("\n2. SORTING EMPLOYEES BY SALARY AND NAME (DESCENDING):");
        // Sort employees by salary (descending) and then by name (descending) if salaries are equal
        List<Employee12> empListDesc = employees.stream()
                .peek((emp) -> {
                    if (emp.getSalary() > 8000) {
                        System.out.println("Employee with salary > 8000: " + emp.getName());
                    }
                })
                .sorted(Comparator.comparing(Employee12::getSalary).reversed()
                        .thenComparing(Comparator.comparing(Employee12::getName).reversed()))
                .toList();

        System.out.println("\nResult after descending sort:");
        empListDesc.forEach(i -> System.out.println(i.getName() + " - $" + i.getSalary()));

        System.out.println("\n3. SORTING USING CUSTOM COMPARATOR:");
        // Custom comparator approach (without using Comparator.comparing())
        List<Employee12> empList1 = employees.stream()
                .sorted((e1, e2) -> {
                    int salaryComparison = Double.compare(e1.getSalary(), e2.getSalary());
                    if (salaryComparison == 0) {
                        return e1.getName().compareTo(e2.getName());
                    }
                    return salaryComparison;
                })
                .toList();

        empList1.forEach(i -> System.out.println(i.getName() + " - $" + i.getSalary()));

        // ------------ EMPLOYEE FILTERING EXAMPLES ------------

        System.out.println("\n4. FILTERING EMPLOYEES BY SALARY:");
        // Filter employees with salary greater than 10000 and extract names
        List<String> filteredNames = employees.stream()
                .filter(emp -> emp.getSalary() > 10000)
                .map(Employee12::getName)
                .toList();

        System.out.println("Employees with salary > 10000:");
        filteredNames.forEach(System.out::println);

        System.out.println("\n5. EXTRACTING AND SORTING SALARIES:");
        // Extract salaries and sort them in descending order
        List<Integer> sortedSalaries = employees.stream()
                .map(Employee12::getSalary)
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println("Salaries in descending order:");
        sortedSalaries.forEach(System.out::println);

        // ------------ ARRAY MERGING EXAMPLES ------------

        System.out.println("\n6. MERGING ARRAYS USING STREAMS:");
        // Example 1: Working with boxed Integer arrays (Stream<Integer>)
        Integer[] firstArray = {10, 20, 30, 40};
        Integer[] secondArray = {50, 60, 70, 80};

        // Arrays.stream(firstArray) creates a Stream<Integer> of boxed Integer objects
        int sum = Arrays.stream(firstArray).reduce(0, Integer::sum);
        System.out.println("Sum of first array: " + sum);

        // Stream.of creates a Stream<Integer[]>, then flatMap converts it to Stream<Integer>
        // containing all elements from both arrays
        Integer[] mergedArray = Stream.of(firstArray, secondArray)
                .flatMap(Arrays::stream)  // flatMap transforms Stream<Integer[]> to Stream<Integer>
                .toArray(Integer[]::new); // Collect back to an Integer[] array

        System.out.println("Merged Integer Arrays: " + Arrays.toString(mergedArray));

        // Example 2: Working with primitive int arrays (IntStream)
        int[] firstArray1 = {10, 20, 30, 40};
        int[] secondArray1 = {50, 60, 70, 80};

        // Arrays.stream(firstArray1) creates an IntStream (primitive specialized stream)
        // which has optimized methods like .sum() that avoid boxing/unboxing
        int sum1 = Arrays.stream(firstArray1).sum();
        System.out.println("Sum of first array: " + sum1);

        // Stream.of creates a Stream<int[]>, then flatMapToInt converts it to IntStream
        // containing all primitive int values from both arrays
        int[] mergedIntArray = Stream.of(firstArray1, secondArray1)
                .flatMapToInt(Arrays::stream)  // flatMapToInt transforms Stream<int[]> to IntStream
                .toArray();  // Collect back to an int[] array (no generator needed for primitives)

        System.out.println("Merged int Arrays: " + Arrays.toString(mergedIntArray));

        // ------------ FLATTENING COLLECTIONS ------------

        System.out.println("\n7. FLATTENING COLLECTIONS:");
        // Flatten a list of lists into a single list
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("one", "two"),
                Arrays.asList("three", "four"),
                Arrays.asList("five", "six")
        );

        List<String> flattenedList = listOfLists.stream()
                .flatMap(Collection::stream)
                .toList();

        System.out.println("Flattened list: " + flattenedList);

        // ------------ STRING CONCATENATION EXAMPLE ------------

        System.out.println("\n8. STRING CONCATENATION:");
        // Concatenate all strings from a list of lists
        List<List<String>> listOfLists1 = Arrays.asList(
                Arrays.asList("one", "two"),
                Arrays.asList("three", "four"),
                Arrays.asList("five", "six"));

        String concatenatedString = listOfLists1.stream()
                .flatMap(Collection::stream)
                .reduce("", (c, f) -> c + " " + f);

        System.out.println("Concatenated string: " + concatenatedString);

        // ------------ ERROR HANDLING EXAMPLE ------------

        System.out.println("\n9. HANDLING ERRORS IN STREAMS:");
        // This would throw an exception because Employee12 doesn't implement Comparable
        List<Employee12> employeeList = Arrays.asList(
                new Employee12(10, "Rajath", 30000),
                new Employee12(11, "Anil Macharam", 10000),
                new Employee12(12, "Akhil Jain", 40000));

        try {
            // This will throw ClassCastException since Employee12 doesn't implement Comparable
            List<Employee12> sorted = employeeList.stream().sorted().toList();
            System.out.println("Sorted list: " + sorted);
        } catch (ClassCastException exception) {
            System.out.println("Error: Cannot sort Employee12 objects without a comparator " +
                    "because Employee12 does not implement Comparable");

            // Proper way to sort with explicit comparator
            List<Employee12> sortedCorrectly = employeeList.stream()
                    .sorted(Comparator.comparing(Employee12::getSalary))
                    .toList();
            System.out.println("Properly sorted by salary: " +
                    sortedCorrectly.stream()
                            .map(e -> e.getName() + " ($" + e.getSalary() + ")")
                            .toList());
        }
    }
}
