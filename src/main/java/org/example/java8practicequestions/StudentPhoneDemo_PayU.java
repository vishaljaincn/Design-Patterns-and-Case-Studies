package org.example.java8practicequestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class StudentPhoneDemo_PayU {

    // Student class with name, list of phone numbers, and department
    static class Student {
        private String name;
        private List<String> phoneNums;
        private String dept;

        public Student(String name, List<String> phoneNums, String dept) {
            this.name = name;
            this.phoneNums = phoneNums;
            this.dept = dept;
        }

        public String getName() {
            return name;
        }

        public List<String> getPhoneNums() {
            return phoneNums;
        }

        public String getDept() {
            return dept;
        }
    }

    public static void main(String[] args) {
        // Sample input data
        List<Student> list = new ArrayList<>();
        list.add(new Student("Alice", Arrays.asList("9008864755", "1234567890"), "CS"));
        list.add(new Student("Bob", Arrays.asList("9008864755", "9876543210"), "Math"));
        list.add(new Student("Charlie", Arrays.asList("5555555555", "1234567890"), "Physics"));

        String givenPhoneNum = "9008864755";

        // Find and print name and dept of students having the given phone number
        list.stream()
                .filter(stu -> stu.getPhoneNums().contains(givenPhoneNum))
                .forEach(stu -> System.out.println(stu.getName() + " " + stu.getDept()));

        // Remove duplicates from all students' phone numbers
        List<String> uniquePhoneNumbers = list.stream()
                .map(Student::getPhoneNums)
                .flatMap(Collection::stream)
                .distinct()
                .toList();

        System.out.println("Unique phone numbers: " + uniquePhoneNumbers);
    }
}
