package be.vdab.dao.impl;

import be.vdab.be.vdab.dao.BasketDao;
import be.vdab.entiteiten.Basket;
import be.vdab.entiteiten.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static be.vdab.be.database.MySqlConnection.getConnection;


public class BasketDaoImpl implements BasketDao {

    private Basket basket = new Basket();

    @Override
    public void saveOrder(Order order) {
        String sql = "insert into orders (paymentMethod, orderTotal, date, custId, eshopId)\n" +
                "values (?,?,?,?,?)";
        try (Connection connection = getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, order.getPaymentMethod());
            pst.setInt(2, order.getOrderTotal());
            pst.setDate(3, order.getDate());
            pst.setInt(4, order.getCustId());
            pst.setInt(5, order.getEshopId());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Basket getBasket() {
        return basket;
    }
}
