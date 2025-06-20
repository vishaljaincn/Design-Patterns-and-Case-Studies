package org.example.Strings;

import java.util.Map;
import java.util.Objects;

public class Student {
    private int id;
    private String name;
    private int age;
    private String adderess;

    public Student(int id, String name, int age, String adderess) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.adderess = adderess;
    }

    public Student() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdderess() {
        return adderess;
    }
    public void print()
    {
        System.out.println(id);
        System.out.println(age);
    }
    public void setAdderess(String adderess) {
        this.adderess = adderess;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", adderess='" + adderess + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && age == student.age && name.equals(student.name) && Objects.equals(adderess, student.adderess);
    }

    @Override
    public int hashCode() {
        super.hashCode();
        return Objects.hash(id, name, age, adderess);
    }
}
