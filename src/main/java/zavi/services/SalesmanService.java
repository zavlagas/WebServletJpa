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
        return(salesmen);
    }
    
}
