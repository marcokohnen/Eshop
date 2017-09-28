package be.vdab.dao.impl;

import be.vdab.be.vdab.dao.OrderDao;
import be.vdab.entiteiten.Customer;
import be.vdab.entiteiten.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static be.vdab.be.database.MySqlConnection.getConnection;

public class OrderDaoImpl implements OrderDao {

    private static int KOLOM_ORDERID;
    private static String KOLOM_PAYMENTMETHOD;
    private static int KOLOM_ORDERTOTAL;
    private static Date KOLOM_DATE;
    private static int KOLOM_CUSTID;
    private static int KOLOM_ESHOPID;

    List<Order> orderList = new ArrayList<>();
    Order order = null;

    @Override
    public List<Order> findOrdersForCustomer(Customer customer) {
        String sql = "Select *\n" +
                "from orders\n" +
                "where custId = ?;";
        try (Connection connection = getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, customer.getCustNumber());
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    KOLOM_ORDERID = rs.getInt("orderId");
                    KOLOM_PAYMENTMETHOD = rs.getString("paymentMethod");
                    KOLOM_ORDERTOTAL = rs.getInt("orderTotal");
                    KOLOM_DATE = rs.getDate("date");
                    KOLOM_CUSTID = rs.getInt("custId");
                    KOLOM_ESHOPID = rs.getInt("eshopId");
                    order = new Order(KOLOM_ORDERID, KOLOM_PAYMENTMETHOD, KOLOM_ORDERTOTAL, KOLOM_DATE, KOLOM_CUSTID, KOLOM_ESHOPID);
                    if (order != null) {
                        orderList.add(order);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }
}
