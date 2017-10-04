package be.vdab.dao.impl;

import be.vdab.be.vdab.dao.ProductDao;
import be.vdab.entiteiten.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static be.vdab.be.database.MySqlConnection.getConnection;

public class ProductDaoImpl implements ProductDao {

    private static int KOLOM_PRODUCTID;
    private static String KOLOM_NAME;
    private static double KOLOM_PRICE;
    private static int KOLOM_STOCK;

    List<Product> productList = new ArrayList<>();
    Product product = null;

    @Override
    public List<Product> findProducts(String productname) {
        String sql = "Select * from product where\n" +
                "name like ?";
        try (Connection connection = getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, "%" + productname + "%");
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    KOLOM_PRODUCTID = rs.getInt("productId");
                    KOLOM_NAME = rs.getString("name");
                    KOLOM_PRICE = rs.getDouble("price");
                    KOLOM_STOCK = rs.getInt("stock");
                    product = new Product(KOLOM_PRODUCTID, KOLOM_NAME, KOLOM_PRICE, KOLOM_STOCK);
                    if (product != null) {
                        productList.add(product);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> getProductList() {
        String sql = "Select * from product";
        try (Connection connection = getConnection();
             Statement st = connection.createStatement()) {
            try (ResultSet rs = st.executeQuery(sql)) {
                while (rs.next()) {
                    KOLOM_PRODUCTID = rs.getInt("productId");
                    KOLOM_NAME = rs.getString("name");
                    KOLOM_PRICE = rs.getDouble("price");
                    KOLOM_STOCK = rs.getInt("stock");
                    product = new Product(KOLOM_PRODUCTID, KOLOM_NAME, KOLOM_PRICE, KOLOM_STOCK);
                    if (product != null) {
                        productList.add(product);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
