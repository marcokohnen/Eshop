package be.vdab.entiteiten;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {

    Customer customer;

    @Before
    public void init() {
        customer = new Customer("testuser", "testPwd",102, "testCust", "testFirstname", "testEmail", "testDilvery");
    }

    @Test
    public void getCustNumber() {
        assertThat(customer.getCustNumber()).isEqualTo(102);
    }

    @Test
    public void getName() {
        assertThat(customer.getName()).isEqualTo("testCust");
    }

    @Test
    public void getFirstName()  {
        assertThat(customer.getFirstName()).isEqualTo("testFirstname");
    }

    @Test
    public void getEmail() {
        assertThat(customer.getEmail()).isEqualTo("testEmail");
    }

    @Test
    public void getDeliveryAddress()  {
        assertThat(customer.getDeliveryAddress()).isEqualTo("testDilvery");
    }

}