package be.vdab.be.vdab.dao;

import be.vdab.entiteiten.Customer;

public interface CustomerDao {

    Customer findCustomers(String name, String firstname, String username);

}
