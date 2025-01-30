package org.example.java8practicequestions;

import java.util.*;
import java.util.stream.Stream;

class Employee12 {
    public int id;


    public String name;

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

    public int salary;

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

    @Override
    public String toString() {
        return "Employee12{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Employee12(int a, String b, int c) {
        this.id = a;
        this.name = b;
        this.salary = c;
    }
}

class Stream1 {
    public static void main(String[] args) {
        ArrayList<Employee12> al = new ArrayList<>();
        al.add(new Employee12(1, "Thejas", 30000));
        al.add(new Employee12(1, "Ranjith", 10000));
        al.add(new Employee12(1, "Shreyas", 40000));
        al.add(new Employee12(1, "Vishal", 20000));
        al.add(new Employee12(1, "Gautam", 20000));

        // Question: Sort the employees first by salary and then by name if salaries are equal
        List<Employee12> empList = al.stream().peek(System.out::println)
                .sorted(Comparator.comparing(Employee12::getSalary).thenComparing(Employee12::getName))
                .toList();

// Sort employees by salary in descending order, and by name in descending order if salaries are equal
        List<Employee12> empListDesc = al.stream().peek((a) -> {
                    if (a.getSalary() > 8000) {
                        System.out.println("the first employee to cross 8000 is: " + a.getName());
                    }
                })
                .sorted(Comparator.comparing(Employee12::getSalary).reversed()
                        .thenComparing(Comparator.comparing(Employee12::getName).reversed()))
                .toList();


        empList.forEach(i -> System.out.println(i.name + "     " + i.salary));

        // Question: Sort the employees first by salary and then by name if salaries are equal without
        // Comparator.comparing
        List<Employee12> empList1 = al.stream()
                .sorted((e1, e2) -> {
                    int salaryComparison = Double.compare(e1.getSalary(), e2.getSalary());
                    if (salaryComparison == 0) {
                        return e1.getName().compareTo(e2.getName());
                    }
                    return salaryComparison;
                })
                .toList();

        empList1.forEach(i -> System.out.println(i.name + "     " + i.salary));

        System.out.println("---------------------------------------------------");

        // Question: Filter employees with salary greater than 10000 and get their names
        List<String> filteredNames = al.stream()
                .filter(i -> i.salary > 10000)
                .map(p -> p.name)
                .toList();

        filteredNames.forEach(System.out::println);

        System.out.println("---------------------------------------------------");

        // Question: Get a list of salaries in descending order
        List<Integer> sortedSalaries = al.stream()
                .map(emp -> emp.salary)
                .sorted((i, j) -> j - i)
                .toList();

        sortedSalaries.forEach(System.out::println);

        System.out.println("-----------------------------------------------------");

        // Question: Merge two arrays of Integer into one array
        Integer[] firstArray = {10, 20, 30, 40};
        Integer[] secondArray = {50, 60, 70, 80};

        Integer[] mergedArray = Stream.of(firstArray, secondArray)
                .flatMap(Arrays::stream)
                .toArray(Integer[]::new);

        System.out.println("Merged Integer Arrays: " + Arrays.toString(mergedArray));

        // Question: Merge two arrays of int into one array
        int[] firstArray1 = {10, 20, 30, 40};
        int[] secondArray1 = {50, 60, 70, 80};

        int[] mergedIntArray = Stream.of(firstArray1, secondArray1)
                .flatMapToInt(Arrays::stream)
                .toArray();

        System.out.println("Merged int Arrays: " + Arrays.toString(mergedIntArray));

        System.out.println("---------------------------------------------------------");

        // Question: Flatten a list of lists into a single list
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("one", "two"),
                Arrays.asList("three", "four"),
                Arrays.asList("five", "six")
        );

        List<String> flattenedList = listOfLists.stream()
                .flatMap(Collection::stream)
                .toList();

        System.out.println("flattenedList: " + flattenedList);


        // Question: Concatenate all strings from a list of lists into a single string
        List<List<String>> listOfLists1 = Arrays.asList(
                Arrays.asList("one", "two"),
                Arrays.asList("three", "four"),
                Arrays.asList("five", "six"));

        String concatenatedString = listOfLists1.stream()
                .flatMap(Collection::stream)
                .reduce("", (c, f) -> c + " " + f);

        System.out.println("The concatenated string is: " + concatenatedString);
    }
}
