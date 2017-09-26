package be.vdab.dao.impl;

import be.vdab.be.vdab.dao.CustomerDao;
import be.vdab.entiteiten.Customer;
import be.vdab.entiteiten.User;

import java.sql.*;

import static be.vdab.be.database.MySqlConnection.getConnection;

public class CustomerDaoImpl implements CustomerDao {

    private static int KOLOM_CUSTID;
    private static String KOLOM_NAME;
    private static String KOLOM_FIRSTNAME;
    private static String KOLOM_EMAIL;
    private static String KOLOM_DELIVERYADDRESS;
    private static String KOLOM_USERNAME;
    private static String KOLOM_PASSWORD;

    Customer customer = null;
    User user = null;

    @Override
    public Customer findCustomers(String name, String firstname, String username) {
        String sql = "select * from customer\n" +
                "where ucase(name)= ?\n" +
                "and ucase(firstName)= ?\n" +
                "and ucase(userName)= ?;";
        try (Connection connection = getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, name);
            pst.setString(2, firstname);
            pst.setString(3,username);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    KOLOM_CUSTID = rs.getInt("custId");
                    KOLOM_NAME = rs.getString("name");
                    KOLOM_FIRSTNAME = rs.getString("firstName");
                    KOLOM_EMAIL= rs.getString("email");
                    KOLOM_DELIVERYADDRESS = rs.getString("deliveryAddress");
                    KOLOM_USERNAME = rs.getString("userName");
                    KOLOM_PASSWORD = rs.getString("passWord");
                    customer = new Customer(KOLOM_USERNAME, KOLOM_PASSWORD, KOLOM_CUSTID, KOLOM_NAME, KOLOM_FIRSTNAME, KOLOM_EMAIL, KOLOM_DELIVERYADDRESS);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public User findByLoginAndUsername(String username, String password) {
        String sql = "select * from customer\n" +
                "where ucase(username)= ?\n" +
                "and ucase(passWord)= ?";
        try (Connection connection = getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, username);
            pst.setString(2, password);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    KOLOM_USERNAME = rs.getString("userName");
                    KOLOM_PASSWORD = rs.getString("passWord");
                    user = new User(KOLOM_USERNAME, KOLOM_PASSWORD);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
