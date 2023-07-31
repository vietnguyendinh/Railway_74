package com.vti.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    public static Connection connection;
    //Tao connection

    public static Connection getConnection() throws ClassNotFoundException, IOException, SQLException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/main/resources/database.properties"));
        String url = prop.getProperty("urlMySql");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        String driver = prop.getProperty("driver");
        Class.forName(driver);
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
    public static void disconnect() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        JdbcUtils jdbc = new JdbcUtils();
        jdbc.getConnection();
    }

}
