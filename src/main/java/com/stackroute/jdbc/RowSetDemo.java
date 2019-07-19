package com.stackroute.jdbc;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class RowSetDemo
{

    public void rowSetDemo()
    {
        System.out.println("\n----------RowSetDemo-----------\n");

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            // Setting database details using JdbcRowSet
            JdbcRowSet jdbcRowSet= RowSetProvider.newFactory().createJdbcRowSet();
            jdbcRowSet.setUrl("jdbc:mysql://localhost:3306/mysqldemo");
            jdbcRowSet.setUsername("root");
            jdbcRowSet.setPassword("Root@123");
            jdbcRowSet.setCommand("select * from emp");
            jdbcRowSet.execute();

            while (jdbcRowSet.next())
            {
                System.out.println("id: " + jdbcRowSet.getInt(1) + " name: " + jdbcRowSet.getString(2) + " age: " + jdbcRowSet.getString(3) + " gender: " + jdbcRowSet.getString(4));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}