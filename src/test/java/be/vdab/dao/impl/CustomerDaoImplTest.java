package be.vdab.dao.impl;

import be.vdab.be.vdab.dao.CustomerDao;
import be.vdab.entiteiten.Customer;
import be.vdab.entiteiten.User;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class CustomerDaoImplTest {

    CustomerDao customerDaoImpl;
    Customer testCust;
    User testUser;

    @Before
    public void init() {
        customerDaoImpl = new CustomerDaoImpl();
    }

    @Test
    public void findCustomers() {
        testCust = customerDaoImpl.findCustomers("Fluitketel", "Flip", "Guest");
        assertThat(testCust.getCustNumber()).isEqualTo(100);
    }

    @Test
    public void findByLoginAndUsername() {
        testUser = customerDaoImpl.findByLoginAndUsername("Guest", "101");
        assertThat(testUser.getPassWord()).isEqualToIgnoringCase("101");
    }

}