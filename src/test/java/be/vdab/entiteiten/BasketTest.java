package be.vdab.entiteiten;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketTest {

    private Basket basket;
    private Product p1, p2;

    @Before
    public void init() {
        basket = new Basket();
        p1 = new Product(1, "p1", 2.95, 10);
        p2 = new Product(2, "p2", 7.95, 15);
        basket.getBasketMap().put(p1, 12);
        basket.getBasketMap().put(p2, 10);
    }

    @Test
    public void testConstructor() {
        assertThat(basket).isInstanceOf(Basket.class);
    }

    @Test
    public void getBasketMap() {
        assertThat(basket.getBasketMap()).isInstanceOf(HashMap.class);
    }

    @Test
    public void addProductToBasket() {
        assertThat(basket.getBasketMap()).hasSize(2);
        assertThat(basket.getBasketMap().containsKey(p2));
    }

    @Test
    public void removeProductFromBasket() {
        basket.removeProductFromBasket(p1);
        assertThat(basket.getBasketMap()).hasSize(1);
        assertThat(basket.getBasketMap().keySet()).doesNotContain(p1);
    }

    @Test
    public void getBasket() {
        assertThat(basket.getBasket()).isInstanceOf(Basket.class);
    }

    @Test
    public void clearBasket() {
        basket.clearBasket();
        assertThat(basket.getBasketMap()).hasSize(0);
    }

}