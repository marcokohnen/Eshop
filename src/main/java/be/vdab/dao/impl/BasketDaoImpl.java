package be.vdab.dao.impl;

import be.vdab.be.vdab.dao.BasketDao;
import be.vdab.entiteiten.Basket;
import be.vdab.entiteiten.Product;


public class BasketDaoImpl implements BasketDao {

    Basket basket = new Basket();

    @Override
    public void saveOrUpdateBasket(Basket basket) {
        this.basket = basket;
    }

    @Override
    public void addProductToBasket(Product product, int aantal) {
        basket.getBasketMap().put(product, aantal);
    }


    @Override
    public void removeProductFromBasket(Product product) {
        if (basket.getBasketMap().get(product) != null) { // alleen als product in basketMap aanwezig wordt deze verwijderd
            basket.getBasketMap().remove(product);
        }
    }

    @Override
    public Basket getBasket() {
        return basket;
    }

    @Override
    public void clearBasket() {
        basket.getBasketMap().clear();
    }
}
