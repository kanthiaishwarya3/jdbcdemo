package com.stackroute.jdbc;
import java.sql.*;

public class SimpleJdbcDemo {

    private Connection connection;
    private  Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;

    public void getEmployeeDetails() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from employee");)
        {
            /*Load driver and register with DriverManager*/

            /*Use DriverManager to get Connection*/
            while (resultSet.next()) {
                System.out.println("id: " + resultSet.getInt(1) + " name: " + resultSet.getString(2));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /*Print ResultSet in reverse order*/

    public void getEmployeeDetailsInReverse()
    {
        System.out.println("\n");
        System.out.println("Printing result in reverse order");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from employee");)
        {
            resultSet.last();
            resultSet.next();
            while (resultSet.previous()) {
                System.out.println("id: " + resultSet.getInt(1) + " name: " + resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /*Move ResultSet to second row and print in reverse order*/
    public void getEmployeeDetailsFromSecondRowInReverse()
    {
        System.out.println("\n");
        System.out.println("From Second Row in Reverse Order");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from employee");)
        {

            resultSet.absolute(2);
            resultSet.next();
            while (resultSet.previous()) {
                System.out.println("id: " + resultSet.getInt(1) + " name: " + resultSet.getString(2));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    //Use PreparedStatement to display by name and gender

    public void getEmployeeDetailsByNameAndGender(String name,String gender) {

        System.out.println("\n");
        System.out.println("Display by name and gender");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");
             PreparedStatement statement = connection.prepareStatement("select * from employee where empname=? and gender=?")) {

            statement.setString(1, name);
            statement.setString(2, gender);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("id: " + resultSet.getInt(1) + " name: " + resultSet.getString(2) + " age: " + resultSet.getString(3) + " gender: " + resultSet.getString(4));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}