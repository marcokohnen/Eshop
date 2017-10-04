package be.vdab.be.vdab.dao;


import be.vdab.entiteiten.Basket;

import java.sql.SQLException;

public interface BasketDao {

    void saveOrder(String paymentMethod, int custId, int esshopId);

    Basket getBasket();

    void testBasketMap();

    public int getProductStock(int productId) throws SQLException;

}
