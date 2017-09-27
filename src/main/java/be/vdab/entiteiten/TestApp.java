package be.vdab.entiteiten;

import be.vdab.be.vdab.dao.CustomerDao;
import be.vdab.be.vdab.dao.OrderDao;
import be.vdab.be.vdab.dao.ProductDao;
import be.vdab.be.vdab.dao.ShopDao;
import be.vdab.dao.impl.CustomerDaoImpl;
import be.vdab.dao.impl.OrderDaoImpl;
import be.vdab.dao.impl.ProductDaoImpl;
import be.vdab.dao.impl.ShopDaoImpl;

import java.sql.Date;

public class TestApp {

    public static void main(String[] args) {

        ShopDao shopdaoimpl = new ShopDaoImpl();
        shopdaoimpl.listAllShops().forEach(System.out::println);

        CustomerDao customerDaoImpl = new CustomerDaoImpl();
        Customer testCust;
        testCust = customerDaoImpl.findCustomers("fluitketel", "flIp", "guest");
        if (testCust != null) {
            System.out.println(testCust.toString());
        }
        else {
            System.out.println("Customer niet gevonden");
        }
        User testUser = null;
        testUser = new User("guest", "101");
        if (testUser != null) {
            System.out.println(testUser.toString());
        }
        else {
            System.out.println("User niet gevonden");
        }

        ProductDao productDaoImpl = new ProductDaoImpl();
        productDaoImpl.findProducts("Fender").forEach(System.out::println);

        OrderDao orderDao = new OrderDaoImpl();
        orderDao.findOrdersForCustomer(testCust).forEach(System.out::println);
        orderDao.saveOrder(new Order ("Paypal", 22, Date.valueOf("2017-07-15"), 100, 1));

    }
}

