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
import zavi.entities.Product;

/**
 *
 * @author User
 */
public class CustomerDao extends SuperDaoManagerFactory {

    public List<Customer> findAllCustomers() {
        EntityManager em = openConnection();
        String sql = ("SELECT c FROM Customer c");
        TypedQuery query = em.createQuery(sql, Customer.class);
        List<Customer> customers = query.getResultList();
        closeConnection();
        return (customers);
    }

    public void createCustomer(Customer c) {
        EntityManager em = openConnection();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        closeConnection();
    }

    public Customer findCustomerBy(int ccode) {
        EntityManager em = openConnection();
        Customer c = em.find(Customer.class, ccode);
        closeConnection();
        return (c);
    }

    public void updateCustomer(Customer c) {
        EntityManager em = openConnection();
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
        closeConnection();
    }

    public void deleteCustomer(Customer c) {
        EntityManager em = openConnection();
        em.getTransaction().begin();
        em.remove(em.find(Customer.class, c.getCcode()));
        em.getTransaction().commit();
        closeConnection();
    }
}
