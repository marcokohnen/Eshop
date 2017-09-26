package be.vdab.be.database;

import java.sql.*;

public class MySqlConnection {

    private static final String URL = "jdbc:mysql://localhost/eshop";
    private static final String USER = "cursist";
    private static final String PASSWORD = "cursist";


    public static void main(String[] args) {
        //test connection to database eshop
        String sql = "select * from product";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("Connection E-shop gelukt");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}


