package com.stackroute.jdbc;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseMetadataDemo
{
    // Declaration
    private Connection connection;

    public void databaseMetaData()
    {
        try {
            // Loading Driver and Registering
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");
            // Retrieving metadata of database
            DatabaseMetaData databasemetadata=connection.getMetaData();
            // Printing the Metadata of database with appropriate methods
            System.out.println("\n ---DatabaseMetadata----\n");
            System.out.println("DriverName: "+databasemetadata.getDriverName());
            System.out.println("DriverVersion: "+databasemetadata.getDriverVersion());
            System.out.println("Database Product Name: "+databasemetadata.getDatabaseProductName());
            System.out.println("URL: "+databasemetadata.getURL());
            System.out.println("Username: "+databasemetadata.getUserName());

        }
        // Catching exceptions raised
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

