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

    @Override
    public String toString() {
        return basketMap.toString();
    }
}

