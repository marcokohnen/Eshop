package be.vdab.entiteiten;

import be.vdab.be.vdab.dao.BasketDao;
import be.vdab.dao.impl.BasketDaoImpl;

public class TestApp {

    public static void main(String[] args) {

//        ShopDao shopdaoimpl = new ShopDaoImpl();
//        shopdaoimpl.listAllShops().forEach(System.out::println);
//
//        CustomerDao customerDaoImpl = new CustomerDaoImpl();
//        Customer testCust;
//        testCust = customerDaoImpl.findCustomers("fluitketel", "flIp", "guest");
//        if (testCust != null) {
//            System.out.println(testCust.toString());
//        } else {
//            System.out.println("Customer niet gevonden");
//        }
//        User testUser = null;
//        testUser = new User("guest", "101");
//        if (testUser != null) {
//            System.out.println(testUser.toString());
//        } else {
//            System.out.println("User niet gevonden");
//        }

        //ProductDao productDaoImpl = new ProductDaoImpl();
        //productDaoImpl.findProducts("Fender").forEach(System.out::println);
        //productDaoImpl.getProductList().forEach(System.out::println);


//        OrderDao orderDao = new OrderDaoImpl();
        BasketDao basketDao = new BasketDaoImpl();
//        orderDao.findOrdersForCustomer(testCust).forEach(System.out::println);
        basketDao.testBasketMap();
        System.out.println("Totalprice basket : " + basketDao.getBasket().getTotalPrice());
        basketDao.saveOrder("Mastercard", 101, 2);


    }
}

