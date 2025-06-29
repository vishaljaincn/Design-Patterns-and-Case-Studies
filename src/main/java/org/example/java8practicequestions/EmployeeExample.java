package org.example.java8practicequestions;

import java.util.*;
import java.util.stream.Collectors;


class Employee1 {
    private int id;
    private String name;
    private String dept;
    private int age;

    public Employee1(int id, String name, String dept, int age) {
        super();
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", dept=" + dept + ", age=" + age + "]";
    }
}

public class EmployeeExample {
    public static void main(String[] args) {
        // Creating Employee objects
        Employee1 employee1 = new Employee1(1, "vishal", "HR", 24);
        Employee1 employee12 = new Employee1(2, "rahul", "dev", 24);
        Employee1 employee13 = new Employee1(3, "sreya", "prod", 24);
        Employee1 employee14 = new Employee1(4, "swetha", "support", 24);
        Employee1 employee15 = new Employee1(5, "rahul", "testing", 24);
        Employee1 employee16 = new Employee1(6, "vishal", "sme", 24);
        Employee1 employee17 = new Employee1(1, "rahul", "lead", 24);

        // Comparing two strings lexicographically
        String string = "hi";
        String string2 = "hello";
        System.out.println(string.compareTo(string2)); // Output: 4

        // Creating a list of employees and adding the employee objects to it
        List<Employee1> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee12);
        list.add(employee13);
        list.add(employee14);
        list.add(employee15);
        list.add(employee16);
        list.add(employee17);

        // Grouping employees by name into lists
        Map<String, List<Employee1>> countMap = list.stream()
                .collect(Collectors.groupingBy(Employee1::getName));
        //System.out.println(countMap); // Would print map with employees grouped by name
        countMap.forEach((name, employeesList) -> System.out.println(name + " = " + employeesList));

        // Creating a list of integers
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6, 1, 2, 3, 2);

        // Grouping integers by value and counting occurrences of each value
        Map<Integer, Long> numcountMap = list2.stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        System.out.println(numcountMap); // Output: {1=2, 2=3, 3=2, 4=1, 5=1, 6=1}

        // Creating another list of integers with duplicates
        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(2);
        list3.add(1);
        list3.add(3);
        list3.add(2);
        list3.add(3);
        list3.add(4);

        // Printing the list of integers with duplicates
        System.out.println(list3); // Output: [1, 2, 1, 3, 2, 3, 4]

        // Converting the list to a HashSet to remove duplicates
        Set<Integer> uniqueSet = new HashSet<>(list3);
        System.out.println(uniqueSet); // Output: [1, 2, 3, 4]

        // Printing the original list to show it hasn't changed after creating HashSet
        System.out.println(list3); // Output: [1, 2, 1, 3, 2, 3, 4]

        // Creating another HashSet from the same list (demonstration of same operation)
        Set<Integer> uniqueSet2 = new HashSet<>(list3);
        System.out.println(uniqueSet2); // Output: [1, 2, 3, 4]

        // Creating a list of strings with duplicates
        List<String> mylist = new ArrayList<>();
        mylist.add("practice");
        mylist.add("code");
        mylist.add("code");
        mylist.add("quiz");
        mylist.add("geeksforgeeks");

        // Using Collections.frequency() method to count occurrences of "code"
        int count = Collections.frequency(mylist, "code");
        System.out.println(count); // Output: 2

        // Explanation of the Collections.frequency() method
        // public static int frequency(Collection<?> c, Object o)
        // Parameters:
        // c - the collection in which to count occurrences of the object
        // o - the object to count in the collection
    }
}
