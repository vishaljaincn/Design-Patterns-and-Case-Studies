package org.example.java8practicequestions;

import java.util.HashMap;

public class NoUpdateHashMap_BlueYonder<K, V> extends HashMap<K, V> {

    @Override
    public V put(K key, V value) {
        // If the key already exists, reject the update by returning the existing value.
        if (containsKey(key)) {
            System.out.println("Update rejected: Key " + key + " already exists.");
            return get(key); // Return the existing value without updating it.
        }
        // If the key doesn't exist, proceed with adding the new entry.
        return super.put(key, value);
    }

    public static void main(String[] args) {

        NoUpdateHashMap_BlueYonder<Integer, String> map = new NoUpdateHashMap_BlueYonder<>();

        System.out.println(map.put(1, "First Entry")); // Prints: null (new entry added)
        System.out.println(map.put(1, "Second Entry")); // Prints: "Update rejected: Key 1 already exists."
        System.out.println(map); // Prints: {1=First Entry}
    }
}


