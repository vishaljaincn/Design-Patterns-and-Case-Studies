package org.example.designpatterns.prototype;

/**
 * The Student class implements the Prototype interface, allowing it to clone itself.
 * It represents a student with attributes such as name, age, personal success percentage (psp),
 * batch, and average batch psp.
 */
public class Student implements Prototype<Student> {
    private String name;
    private int age;
    private double psp;
    private String batch;
    private double avgBatchPsp;

    /**
     * Default constructor for creating an empty Student object.
     */
    public Student() {}

    /**
     * Copy constructor for creating a new Student object by copying another Student.
     *
     * @param student the Student object to copy
     */
    public Student(Student student) {
        this.name = student.name;
        this.age = student.age;
        this.batch = student.batch;
        this.psp = student.psp;
        this.avgBatchPsp = student.avgBatchPsp;
    }

    /**
     * Sets the name of the student.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the age of the student.
     *
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Sets the personal success percentage (psp) of the student.
     *
     * @param psp the psp to set
     */
    public void setPsp(double psp) {
        this.psp = psp;
    }

    /**
     * Sets the batch of the student.
     *
     * @param batch the batch to set
     */
    public void setBatch(String batch) {
        this.batch = batch;
    }

    /**
     * Sets the average batch psp of the student.
     *
     * @param avgBatchPsp the average batch psp to set
     */
    public void setAvgBatchPsp(double avgBatchPsp) {
        this.avgBatchPsp = avgBatchPsp;
    }

    /**
     * Creates and returns a copy of the current Student object.
     *
     * @return a clone of the current Student object
     */
    @Override
    public Student clone() {
        // Using the copy constructor to create a new Student object
        Student copy = new Student(this);
        return copy;
    }
}
