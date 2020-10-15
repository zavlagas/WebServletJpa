/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zavi.services;

import java.util.List;
import zavi.dao.SalesmanDao;
import zavi.entities.Salesman;

/**
 *
 * @author User
 */
public class SalesmanService {

    SalesmanDao smdao = new SalesmanDao();

    public List<Salesman> getAllSalesmen() {
        List<Salesman> salesmen = smdao.getAllSalesmen();
        return (salesmen);
    }

    public void createSalesman(String name, String city, String comm) {
        double commision = Double.parseDouble(comm);
        Salesman salesman = new Salesman(name, city, commision);
        smdao.createSalesman(salesman);
    }

    public Salesman findSalesmanBy(String id) {
        int smcode = Integer.parseInt(id);
        Salesman salesman = smdao.findSalesmanBy(smcode);
        return (salesman);
    }

    public void updateSalesman(String id, String name, String city, String comm) {
        Salesman salesman = findSalesmanBy(id);
        double commision = Double.parseDouble(comm);
        salesman.setSname(name);
        salesman.setScity(city);
        salesman.setScomm(commision);
        smdao.updateSalesman(salesman);
    }

    public void deleteSalesmanBy(String id) {
        Salesman salesman = findSalesmanBy(id);
        smdao.deleteSalesman(salesman);
    }

    public Salesman findSalesmanWithFamilyBy(String id) {
        int scode = Integer.parseInt(id);
        Salesman salesman = smdao.findSalesmanWithFamilyBy(scode);
        return (salesman);
    }

}
