package be.vdab.entiteiten;

import be.vdab.be.vdab.dao.*;
import be.vdab.dao.impl.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestApp {

    public static void main(String[] args) {

        ShopDao shopdaoimpl = new ShopDaoImpl();
        shopdaoimpl.listAllShops().forEach(System.out::println);

        CustomerDao customerDaoImpl = new CustomerDaoImpl();
        Customer testCust;
        testCust = customerDaoImpl.findCustomers("fluitketel", "flIp", "guest");
        if (testCust != null) {
            System.out.println(testCust.toString());
        } else {
            System.out.println("Customer niet gevonden");
        }
        User testUser = null;
        testUser = new User("guest", "101");
        if (testUser != null) {
            System.out.println(testUser.toString());
        } else {
            System.out.println("User niet gevonden");
        }

        ProductDao productDaoImpl = new ProductDaoImpl();
        productDaoImpl.findProducts("Fender").forEach(System.out::println);

        OrderDao orderDao = new OrderDaoImpl();
        orderDao.findOrdersForCustomer(testCust).forEach(System.out::println);
        orderDao.saveOrder(new Order("Paypal", 22, Date.valueOf("2017-07-15"), 100, 1));

        BasketDao basketDao = new BasketDaoImpl();
        List<Product> testList = new ArrayList<>();
        testList.add(new Product(1, "p1", 2.95, 10));
        testList.add(new Product(1, "p1", 2.95, 10));
        testList.add(new Product(2, "p2", 7.39, 15));
        testList.add(new Product(3, "p3", 12.95, 22));
        for (Product eenProduct : testList) {
            basketDao.addProductToBasket(eenProduct, 10);
        }
        //Map<Product, Integer> basketMap = basketDao.getBasket().getBasketMap();
        //System.out.println(basketMap.entrySet());
        System.out.println(basketDao.getBasket().getBasketMap());
    }
}

