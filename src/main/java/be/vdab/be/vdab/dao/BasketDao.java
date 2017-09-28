package be.vdab.be.vdab.dao;


import be.vdab.entiteiten.Basket;
import be.vdab.entiteiten.Order;

public interface BasketDao {

    void saveOrder(Order order);

    Basket getBasket();

}
