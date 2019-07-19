package com.stackroute.jdbc;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        // Implementing all classes
        SimpleJdbcDemo simpleJdbcDemo = new SimpleJdbcDemo();
        simpleJdbcDemo.getEmployeeDetails();
        System.out.println("----------------------------------------------------------");
        simpleJdbcDemo.getEmployeeDetailsInReverse();
        System.out.println("----------------------------------------------------------");
        simpleJdbcDemo.getEmployeeDetailsFromSecondRowInReverse();
        System.out.println("----------------------------------------------------------");
        simpleJdbcDemo.getEmployeeDetailsByNameAndGender("aishu","female");
        System.out.println("----------------------------------------------------------");
        RowSetDemo rowsetdemo=new RowSetDemo();
        rowsetdemo.rowSetDemo();
        System.out.println("----------------------------------------------------------");
        ResultSetMetadataDemo resultsetmetadatademo=new ResultSetMetadataDemo();
        resultsetmetadatademo.getResultSetMetadata();
        JdbcBatchDemo jdbcBatchDemo=new JdbcBatchDemo();
        System.out.println("----------------------------------------------------------");
        jdbcBatchDemo.jdbcBatch();
        System.out.println("----------------------------------------------------------");
        DatabaseMetadataDemo databaseMetadataDemo=new DatabaseMetadataDemo();
        System.out.println("----------------------------------------------------------");
        databaseMetadataDemo.databaseMetaData();
        JdbcTransactionDemo jdbcTransactionDemo=new JdbcTransactionDemo();
        System.out.println("----------------------------------------------------------");
        try {
            jdbcTransactionDemo.jdbcTransaction();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}