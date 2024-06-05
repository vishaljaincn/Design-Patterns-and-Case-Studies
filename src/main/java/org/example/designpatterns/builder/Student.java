package org.example.designpatterns.builder;

public class Student {

    // Required student attributes
    private final String name;
    private final int age;
    private final String univName;
    private final int gradYear;
    private final double psp; // Assuming psp stands for something relevant
    private final String batch;

    // Optional attribute (can be null)
    private final String companyName;

    // Encapsulate student data using a private constructor
    private Student(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.univName = builder.univName;
        this.gradYear = builder.gradYear;
        this.psp = builder.psp;
        this.batch = builder.batch;
        this.companyName = builder.companyName;
    }

    // Public static method to get a Student builder instance
    public static Builder getBuilder() {
        return new Builder();
    }

    // Getter methods for all attributes
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getUnivName() {
        return univName;
    }

    public int getGradYear() {
        return gradYear;
    }

    public double getPsp() {
        return psp;
    }

    public String getBatch() {
        return batch;
    }

    public String getCompanyName() {
        return companyName;
    }

    // Builder inner class for constructing Student objects
    public static class Builder {

        private String name;
        private int age;
        private String univName;
        private int gradYear;
        private double psp;
        private String batch;
        private String companyName;

        // Setters for all attributes (returning "this" for method chaining)
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setUnivName(String univName) {
            this.univName = univName;
            return this;
        }

        public Builder setGradYear(int gradYear) {
            this.gradYear = gradYear;
            return this;
        }

        public Builder setPsp(double psp) {
            this.psp = psp;
            return this;
        }

        public Builder setBatch(String batch) {
            this.batch = batch;
            return this;
        }

        public Builder setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        // Perform validations before building the Student object
        private boolean validate() {
            return gradYear <= 2022; // Ensure graduation year is valid
        }

        // Build the Student object and perform final validations
        public Student build() {
            if (!validate()) {
                throw new IllegalArgumentException("Graduation year cannot be greater than 2022");
            }
            return new Student(this);
        }
    }
}
