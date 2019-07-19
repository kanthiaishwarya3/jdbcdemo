package com.stackroute.jdbc;

import java.sql.*;

public class JdbcTransactionDemo
{
    //Declaration
    private Connection connection;
    private Statement statement;


    public void jdbcTransaction() throws SQLException
    {
        Connection connection=null;
        try {
            // Loading and Registering with Drivermanager
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try
        {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");
            Statement statement = connection.createStatement();
            // Implementing transaction
            connection.setAutoCommit(false);
            statement.executeUpdate("insert into employee values(8,'XYZ',30,'Male')");
            System.out.println("\n--------JDBC Transaction Commited----------");
            connection.commit();

        } catch (SQLException exception) {

            connection.rollback();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
