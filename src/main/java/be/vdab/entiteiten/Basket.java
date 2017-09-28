package be.vdab.entiteiten;

import java.util.HashMap;
import java.util.Map;

public class Basket {

    private Map<Product, Integer> basketMap;

    public Basket() {
        basketMap = new HashMap<>();
    }

    public Map<Product, Integer> getBasketMap() {
        return basketMap;
    }

    public void saveOrUpdateBasket(Basket basket) {
        this.basketMap = basket.basketMap;
    }

    public void addProductToBasket(Product product, int aantal) {
        basketMap.put(product, aantal);
    }


    public void removeProductFromBasket(Product product) {
        basketMap.remove(product);
    }

    public Basket getBasket() {
        return this;
    }

    public void clearBasket() {
        basketMap.clear();
    }

    @Override
    public String toString() {
        return basketMap.toString();
    }
}

