package com.cs26l.focuslist;

import java.io.*;
import java.sql.*;
import java.util.Properties;

class Main2 {
    public static void main(String[] args) {
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.add_column("focuslist_db", "id", "int");
    }
}

public class DatabaseManager {

    private Connection connection() {
        Connection main_connection = null;

        try {
            main_connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return main_connection;
    }

    void create_database(String database_name) {
        try {
            String text = "CREATE DATABASE IF NOT EXISTS " + database_name;
            Statement statement = connection().createStatement();
            statement.execute(text);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void auto_create_table() {
        try {
            String text = "CREATE TABLE focuslist_db.accounts (email VARCHAR(255), password VARCHAR(255), username VARCHAR(255))";
            Statement statement = connection().createStatement();
            statement.execute(text);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void add_column(String database_name, String column_name, String datatype) {
        try {
            String text = "ALTER TABLE " + database_name + ".accounts ADD " + column_name + " " + datatype;
            Statement statement = connection().createStatement();
            statement.execute(text);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void add_column(String database_name, String column_name, String datatype, String after_column) {
        try {
            String text = "ALTER TABLE " + database_name + ".accounts ADD " + column_name + " " + datatype + " AFTER " + after_column;
            Statement statement = connection().createStatement();
            statement.execute(text);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void update(String column_name, String value, String where) throws SQLException {
        String text = "UPDATE ";
        PreparedStatement statement = connection().prepareStatement(text);
    }

    void delete(String value, String table) throws SQLException {
        String text = ("DELETE %s FROM %s");
        PreparedStatement statement = connection().prepareStatement(text);
    }

    void delete(String value, String table, String condition) throws SQLException {
        String text = ("DELETE %s FROM %s WHERE &s");
        PreparedStatement statement = connection().prepareStatement(text);
    }
}

class FileManager {
    // CREATE PROPERTIES OBJECT
    // CREATE INPUTSTREAM OBJECT TO READ CONFIG FILE
    // LOAD INPUTSTREAM OBJECT TO PROPERTIES
    // ACCESS CONTENTS USING properties.getProperty
    void read_ini() throws IOException {
        Properties properties = new Properties();
        InputStream input = new FileInputStream("config.ini");
        properties.load(input);
        System.out.println(properties.getProperty("MESSAGE"));
    }

    void read_sample() throws IOException {
        Properties props = new Properties();
        InputStream file = new FileInputStream("config.ini");
        props.load(file);
        System.out.println(props.getProperty("BACKGROUND-COLOR"));
    }
}