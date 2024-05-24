package org.example.ExceptionHandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//  TO EXPLAIN HOW FINALLY BLOCK WORKS WITHOUT CATCH BLOCK, JUST RUN THE CODE, YOU'LL GET TO KNOW
public class SQLExceptionExample {

    public static void main(String[] args) throws SQLException {

        executeSQL();
    }

    public static void executeSQL() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        try {
            // Establish database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/example", "username", "password");

            // Execute SQL statement
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO example_table (column1, column2) VALUES ('value1', 'value2')");

            // Additional SQL operations
        } finally {
            System.out.println("hi hello");
            // Close resources
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
