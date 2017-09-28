package be.vdab.dao.impl;

import be.vdab.be.vdab.dao.OrderDao;
import be.vdab.entiteiten.Customer;
import be.vdab.entiteiten.Order;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class OrderDaoImplTest {

    List<Order> orderList;
    OrderDao orderDaoImpl;
    Customer testCust;

    @Before
    public void init() {
        orderList = new ArrayList<>();
        orderDaoImpl = new OrderDaoImpl();
        testCust = new Customer("testUserName","testPwd", 101, "testName", "testFirstName", "testEmail", "testDeliv");
    }

    @Test
    public void findOrdersForCustomer() {
        orderList = orderDaoImpl.findOrdersForCustomer(testCust);
        assertThat(orderList).isInstanceOf(List.class);
        assertThat(orderList).extracting(order -> order.getOrderId()).contains(2,4,5);
    }
}