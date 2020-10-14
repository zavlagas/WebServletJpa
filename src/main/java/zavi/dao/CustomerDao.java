/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zavi.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import zavi.entities.Customer;

/**
 *
 * @author User
 */
public class CustomerDao extends SuperDaoManagerFactory {

    public List<Customer> findAllCustomers() {
        EntityManager em = openConnection();
        String sql = ("SELECT c FROM Customer c");
        TypedQuery query = em.createQuery(sql,Customer.class);
        List<Customer> customers = query.getResultList();
        closeConnection();
        return(customers);
    }
}
