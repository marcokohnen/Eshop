package be.vdab.entiteiten;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.assertj.core.api.Assertions.*;

public class OrderTest {

    Order order;

    @Before
    public void init() {
        order = new Order(13,"viSA", 20, Date.valueOf("2017-09-28"), 100, 1);
    }

    @Test
    public void getOrderId() {
        assertThat(order.getOrderId()).isEqualTo(13);
    }

    @Test
    public void getPaymentMethod() {
        assertThat(order.getPaymentMethod()).isEqualTo("viSA");
    }

    @Test
    public void getOrderTotal() {
        assertThat(order.getOrderTotal()).isEqualTo(20);
    }

    @Test
    public void getDate() {
        assertThat(order.getDate()).isEqualTo(Date.valueOf("2017-09-28"));
    }

    @Test
    public void getCustId() {
        assertThat(order.getCustId()).isEqualTo(100);
    }

    @Test
    public void getEshopId()  {
        assertThat(order.getEshopId()).isEqualTo(1);
    }

}