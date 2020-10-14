/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zavi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author User
 */
public class SuperDaoManagerFactory {

    private  EntityManagerFactory emf;
    private  EntityManager em;

    protected void openEntityManagerFactory() {
        emf = Persistence.createEntityManagerFactory("salesPU");
    }

    protected void closeEntityManagerFactory() {

        emf.close();
    }

    protected EntityManager getEntityManager() {
        em = emf.createEntityManager();

        return (em);
    }

    protected void closeEntityManager() {
        em.close();
    }

    protected EntityManager openConnection() {
        openEntityManagerFactory();
        EntityManager em1 = getEntityManager();
        return (em1);
    }

    protected void closeConnection() {
        em.close();
        emf.close();
    }

}
