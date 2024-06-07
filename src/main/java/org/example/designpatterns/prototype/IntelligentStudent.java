package org.example.designpatterns.prototype;

/**
 * The IntelligentStudent class extends the Student class and adds an additional attribute for IQ.
 * It implements the Prototype pattern, allowing it to create a copy of itself.
 */
public class IntelligentStudent extends Student {
    private int iq;

    /**
     * Default constructor for creating an empty IntelligentStudent object.
     */
    public IntelligentStudent() {}

    /**
     * Copy constructor for creating a new IntelligentStudent object by copying another IntelligentStudent.
     *
     * @param intelligentStudent the IntelligentStudent object to copy
     */
    public IntelligentStudent(IntelligentStudent intelligentStudent) {
        super(intelligentStudent); // Call the copy constructor of the superclass (Student)
        this.iq = intelligentStudent.iq;
    }

    /**
     * Creates and returns a copy of the current IntelligentStudent object.
     *
     * @return a clone of the current IntelligentStudent object
     */
    @Override
    public IntelligentStudent clone() {
        // Using the copy constructor to create a new IntelligentStudent object
        IntelligentStudent intelligentStudent = new IntelligentStudent(this);
        return intelligentStudent;
    }

    /**
     * Gets the IQ of the intelligent student.
     *
     * @return the IQ value
     */
    public int getIq() {
        return iq;
    }

    /**
     * Sets the IQ of the intelligent student.
     *
     * @param iq the IQ value to set
     */
    public void setIq(int iq) {
        this.iq = iq;
    }
}
