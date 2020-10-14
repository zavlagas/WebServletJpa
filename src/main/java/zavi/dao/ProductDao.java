/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zavi.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import zavi.entities.Product;


public class ProductDao extends SuperDaoManagerFactory {

    public List<Product> getAllProducts() {
        EntityManager em = openConnection();
        String sql = ("SELECT p FROM Product p");
        TypedQuery query = em.createQuery(sql, Product.class);
        List<Product> products = query.getResultList();
        closeConnection();
        return (products);
    }

    public void createProduct(Product p) {
        EntityManager em = openConnection();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        closeConnection();
    }

    public Product findProductBy(int pcode) {
        EntityManager em = openConnection();
        Product p = em.find(Product.class, pcode);
        closeConnection();
        return (p);
    }

    public void updateProduct(Product p) {
        EntityManager em = openConnection();
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        closeConnection();
    }

    public void deleteProduct(Product p) {
        EntityManager em = openConnection();
        em.getTransaction().begin();
        em.remove(em.find(Product.class, p.getPcode()));
        em.getTransaction().commit();
        closeConnection();
    }

}
