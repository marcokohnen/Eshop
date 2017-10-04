package be.vdab.dao.impl;

import be.vdab.be.vdab.dao.BasketDao;
import be.vdab.entiteiten.Basket;
import be.vdab.entiteiten.Product;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static be.vdab.be.database.MySqlConnection.getConnection;


public class BasketDaoImpl implements BasketDao {

    private Basket basket = new Basket();

    @Override
    public void saveOrder(String paymentMethod, int custId, int esshopId) {
        int newOrderId;
        String sqlNewOrder = "insert into orders (paymentMethod, orderTotal, date, custId, eshopId)\n" +
                "values (?,?,?,?,?)";
        String sqlNewOrderDetail = "insert into order_detail (orderId, amount, productId)\n" +
                "values (?,?,?)";
        String sqlUpdateProductStock = "update product set stock = ? where productId = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstNewOrder = connection.prepareStatement(sqlNewOrder, Statement.RETURN_GENERATED_KEYS)) {
            connection.setAutoCommit(false);
            pstNewOrder.setString(1, paymentMethod);
            pstNewOrder.setDouble(2, basket.getTotalPrice());
            pstNewOrder.setDate(3, Date.valueOf(LocalDate.now()));
            pstNewOrder.setInt(4, custId);
            pstNewOrder.setInt(5, esshopId);
            pstNewOrder.executeUpdate();  // insert new order
            // get new orderId
            try (ResultSet rs = pstNewOrder.getGeneratedKeys()) {
                rs.next();
                newOrderId = (int) rs.getLong(1);
                System.out.println("Nieuw ordernr = " + newOrderId);
            }
            //insert new order_details
            PreparedStatement pstNewOrderDetail = connection.prepareStatement(sqlNewOrderDetail);
            //pst2.executeUpdate("SET FOREIGN_KEY_CHECKS=0");
            for (Product eenProduct : basket.getBasketMap().keySet()) {
                try {
                    pstNewOrderDetail.setInt(1, newOrderId);
                    pstNewOrderDetail.setInt(2, basket.getBasketMap().get(eenProduct));
                    pstNewOrderDetail.setInt(3, eenProduct.getProductId());
                    pstNewOrderDetail.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // update product stock
            PreparedStatement pstUpdateProductStock = connection.prepareStatement(sqlUpdateProductStock);
            int newStock = 0;
            for (Product eenProduct : basket.getBasketMap().keySet()) {
                try {
                    try {
                        newStock = getProductStock(eenProduct.getProductId()) >= basket.getBasketMap().get(eenProduct) ?
                                getProductStock(eenProduct.getProductId()) - basket.getBasketMap().get(eenProduct) : 0;
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    System.out.println("productId = " + eenProduct.getProductId());
                    System.out.println("aantal besteld =" + basket.getBasketMap().get(eenProduct));
                    System.out.println("newstock = " + newStock);
                    pstUpdateProductStock.setInt(1, newStock);
                    pstUpdateProductStock.setInt(2, eenProduct.getProductId());
                    pstUpdateProductStock.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            connection.commit();
            //pst2.executeUpdate("SET FOREIGN_KEY_CHECKS=1");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getProductStock(int productId) throws SQLException {
        int stock = 0;
        String sqlSelectStock = "select stock from product where productId = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstProductStock = connection.prepareStatement(sqlSelectStock)) {
            connection.setAutoCommit(false);
            pstProductStock.setInt(1, productId);
            try (ResultSet rsStock = pstProductStock.executeQuery()) {
                rsStock.next();
                stock = rsStock.getInt("stock");
                System.out.println("product stock = " + stock);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stock;
    }

    public void testBasketMap() {
        List<Product> testList = new ArrayList<>();
        testList.add(new Product(1001, "p1", 4, 10));
        testList.add(new Product(1001, "p1", 3, 10));
        testList.add(new Product(1002, "p3", 2, 5));
        testList.add(new Product(1003, "p4", 1, 2));
        for (Product eenProduct : testList) {
            basket.addProductToBasket(eenProduct);
        }
    }

    @Override
    public Basket getBasket() {
        return basket;
    }
}
