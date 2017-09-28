package be.vdab.entiteiten;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.*;

public class BasketTest {

    private Basket basket;

    @Before
    public void init() {
        basket = new Basket();
    }

    @Test
    public void testConstructor() {
        assertThat(basket).isInstanceOf(Basket.class);
        assertThat(basket.getBasketMap()).isInstanceOf(HashMap.class);
    }

}