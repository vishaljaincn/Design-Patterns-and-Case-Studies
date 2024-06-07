package org.example.designpatterns.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * The StudentRegistry class is responsible for storing and retrieving prototypes of Student objects.
 * It allows registering prototypes with a key and retrieving clones of these prototypes using the key.
 */
public class StudentRegistry {
    private Map<String, Student> map = new HashMap<>();

    /**
     * Registers a Student prototype with a given key.
     *
     * @param key     the key with which the Student prototype is to be associated
     * @param student the Student prototype to be registered
     */
    public void register(String key, Student student) {
        map.put(key, student);
    }

    /**
     * Retrieves a clone of the Student prototype associated with the given key.
     *
     * @param key the key whose associated Student prototype is to be returned
     * @return a clone of the Student prototype associated with the key
     */
    public Student get(String key) {
        Student prototype = map.get(key);
        return (prototype != null) ? prototype.clone() : null;
    }
}
