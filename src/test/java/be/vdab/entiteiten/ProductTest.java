package be.vdab.entiteiten;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ProductTest {

    Product product;

    @Before
    public void init() {
        product = new Product(1004, "Gitaar Spaans", 1795.55, 8);
    }

    @Test
    public void getProductId() {
        assertThat(product.getProductId()).isEqualTo(1004);
    }

    @Test
    public void getName() {
        assertThat(product.getName()).isEqualTo("Gitaar Spaans");
    }

    @Test
    public void getPrice() {
        assertThat(product.getPrice()).isEqualTo(1795.55);
    }

    @Test
    public void getStock() {
        assertThat(product.getStock()).isEqualTo(8);
    }

}