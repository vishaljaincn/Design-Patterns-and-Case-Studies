package org.example.designpatterns.prototype;

/**
 * The Client class demonstrates the use of the Prototype design pattern with a StudentRegistry.
 * It registers prototype instances of Student and IntelligentStudent, and retrieves clones of these prototypes.
 */
public class Client {

    /**
     * Fills the given StudentRegistry with template Student objects.
     *
     * @param registry the StudentRegistry to be filled with prototype Student objects
     */
    private static void fillRegistry(StudentRegistry registry) {
        // Create and register a standard Student prototype
        Student mar22MorningStudent = new Student();
        mar22MorningStudent.setBatch("Mar22 Morning");
        mar22MorningStudent.setAvgBatchPsp(70.0);
        registry.register("mar22MorningStudent", mar22MorningStudent);

        // Create and register an IntelligentStudent prototype
        IntelligentStudent mar22MorningIntelligentStudent = new IntelligentStudent();
        mar22MorningIntelligentStudent.setIq(180);
        mar22MorningIntelligentStudent.setBatch("Mar22 Morning");
        mar22MorningIntelligentStudent.setAvgBatchPsp(70.0);
        registry.register("mar22MorningIntelligentStudent", mar22MorningIntelligentStudent);
    }

    /**
     * The main method where the program execution begins.
     * It demonstrates the retrieval and customization of cloned Student objects from the registry.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Fill the registry with template objects
        StudentRegistry registry = new StudentRegistry();
        fillRegistry(registry);

        // Retrieve and customize a clone of the standard Student prototype
        Student parag = registry.get("mar22MorningStudent").clone();
        parag.setName("Parag");
        parag.setAge(25);
        parag.setPsp(80.0);

        // Retrieve and customize a clone of the IntelligentStudent prototype
        Student koteshwara = registry.get("mar22MorningIntelligentStudent").clone();

        // This is a placeholder for further operations or checks
        System.out.println("DEBUG");
    }
}
