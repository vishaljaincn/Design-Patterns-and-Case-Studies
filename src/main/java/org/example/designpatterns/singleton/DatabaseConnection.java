package org.example.designpatterns.singleton;

/**
 * The DatabaseConnection class implements the Singleton design pattern to ensure
 * that only one instance of the class exists throughout the application.
 * It provides a global access point to the instance.
 */
public class DatabaseConnection {
    // Static variable to hold the single instance of the DatabaseConnection
    // It is initially set to null and will be instantiated when needed.
    // The volatile keyword ensures that multiple threads handle the instance correctly
    private static volatile DatabaseConnection dbc = null;

    // Database connection details
    String url;
    String username;
    String password;
    int portNumber;
    String privateKey;

    /**
     * Private constructor to prevent instantiation from outside the class.
     * This ensures that the class can only be instantiated from within.
     */
    private DatabaseConnection() {
        // Initialization code for the database connection can be added here
    }

    /**
     * Returns the single instance of DatabaseConnection, creating it if it doesn't already exist.
     * This method uses double-checked locking to ensure thread safety while minimizing synchronization overhead.
     *
     * @return the single instance of DatabaseConnection
     */
    public static DatabaseConnection getInstance() {
        if (dbc == null) { // Check-1: First check (without locking)
            synchronized (DatabaseConnection.class) { // lock.lock();
                if (dbc == null) { // Check-2: Second check (with locking)
                    dbc = new DatabaseConnection();
                }
            }
        }
        return dbc;
    }
}
