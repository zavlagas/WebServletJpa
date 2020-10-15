/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zavi.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import zavi.entities.Salesman;

/**
 *
 * @author User
 */
public class SalesmanDao extends SuperDaoManagerFactory {

    public List<Salesman> getAllSalesmen() {
        EntityManager em = openConnection();
        String sql = "SELECT sm FROM Salesman sm";
        TypedQuery query = em.createQuery(sql, Salesman.class);
        List<Salesman> salesmen = query.getResultList();
        closeConnection();
        return (salesmen);
    }

    public void createSalesman(Salesman salesman) {
        EntityManager em = openConnection();
        em.getTransaction().begin();
        em.persist(salesman);
        em.getTransaction().commit();
        closeConnection();
    }

    public Salesman findSalesmanBy(int smcode) {
        EntityManager em = openConnection();
        em.getTransaction().begin();
        Salesman salesman = em.find(Salesman.class, smcode);
        em.getTransaction().commit();
        closeConnection();
        return (salesman);
    }

    public void updateSalesman(Salesman salesman) {
        EntityManager em = openConnection();
        em.getTransaction().begin();
        em.merge(salesman);
        em.getTransaction().commit();
        closeConnection();
    }

    public void deleteSalesman(Salesman salesman) {
        EntityManager em = openConnection();
        em.getTransaction().begin();
        em.remove(em.find(Salesman.class, salesman.getScode()));
        em.getTransaction().commit();
        closeConnection();
    }

    public Salesman findSalesmanWithFamilyBy(int scode) {
        Salesman salesman;
        EntityManager em = openConnection();
        TypedQuery<Salesman> query = em.createNamedQuery("Salesman.findSalesmanFamilyByScode", Salesman.class);
        query.setParameter("id", scode);
        try {
            salesman = query.getSingleResult();
        } catch (NoResultException nre) {
            salesman = findSalesmanBy(scode);
        } finally {
            closeConnection();
        }

        return (salesman);
    }

}
