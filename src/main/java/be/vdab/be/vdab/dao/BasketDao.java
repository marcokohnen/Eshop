package be.vdab.be.vdab.dao;


import be.vdab.entiteiten.Basket;
import be.vdab.entiteiten.Product;

public interface BasketDao {

    void saveOrUpdateBasket(Basket basket);

    void addProductToBasket(Product product, int aantal);

    void removeProductFromBasket(Product product);

    Basket getBasket();

    void clearBasket();


}
