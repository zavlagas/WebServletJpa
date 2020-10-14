/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zavi.services;

import java.util.List;
import zavi.dao.CustomerDao;
import zavi.entities.Customer;

/**
 *
 * @author User
 */
public class CustomerService {

    CustomerDao cdao = new CustomerDao();

    public List<Customer> findAllCustomers() {
        List<Customer> customers = cdao.findAllCustomers();
        return (customers);
    }

    public void createCustomer(String name) {
        Customer c = new Customer(name);
        cdao.createCustomer(c);
    }

    public Customer findCustomerBy(String id) {
        int ccode = Integer.parseInt(id);
        Customer c = cdao.findCustomerBy(ccode);
        return (c);
    }

    public void updateCustomer(String id, String name) {
        Customer c = findCustomerBy(id);
        c.setCname(name);
        cdao.updateCustomer(c);
    }

    public void deleteCustomerBy(String id) {
        Customer c = findCustomerBy(id);
        cdao.deleteCustomer(c);
    }

}
