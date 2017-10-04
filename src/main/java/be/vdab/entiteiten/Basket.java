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

    public void addProductToBasket(Product product) {
        if (basketMap.containsKey(product)) { // als product al in basket --> verhoog aantal met 1
            basketMap.put(product, basketMap.get(product) + 1);
        } else {
            basketMap.put(product, 1); //als product niet in basket --> zet aantal = 1
        }
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

    public double getTotalPrice() {
        double totalPrice = 0.0F;
        for (Product eenProduct : basketMap.keySet()) {
            totalPrice += (eenProduct.getPrice() * basketMap.get(eenProduct));
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return basketMap.toString();
    }
}

