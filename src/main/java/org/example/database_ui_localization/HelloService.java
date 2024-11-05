package org.example.database_ui_localization;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HelloService {
    public void insertEmployeeData(String firstName, String lastName, String email, String language) {
        try {
            // Establishing a connection to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/localization", "root", "root");

            // Prepare the SQL statement based on the selected language
            String sql;
            switch (language) {
                case "English":
                    sql = "INSERT INTO employees_en (first_name, last_name, email) VALUES (?, ?, ?)";
                    break;
                case "Farsi":
                    sql = "INSERT INTO employees_fa (first_name, last_name, email) VALUES (?, ?, ?)";
                    break;
                case "Japanese":
                    sql = "INSERT INTO employees_ja (first_name, last_name, email) VALUES (?, ?, ?)";
                    break;
                default:
                    System.out.println("Invalid choice!");
                    return;
            }

            // Creating a PreparedStatement
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);

            // Executing the statement
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Employee data inserted successfully!");
            } else {
                System.out.println("Failed to insert employee data.");
            }

            // Closing resources
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}