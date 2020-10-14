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

}
