/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zavi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import org.hibernate.LazyInitializationException;

@NamedQuery(name = "Salesman.findSalesmanFamilyByScode", query = "SELECT s FROM Salesman s JOIN FETCH s.members m WHERE s.scode=:id")
@Entity
public class Salesman implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//DB will create the primary key (auto increment)
    private int scode;
    private String sname;
    private String scity;
    private double scomm;
    @OneToMany(mappedBy = "salesman", cascade = {CascadeType.PERSIST, CascadeType.MERGE})//JPA LOOK AT THE FIELD SALESMAN TO FIND OUT HOW TO MAP THE TABLES
    private List<Family> members;
    @OneToMany(mappedBy = "salesman")
    private List<Sales> sales;

    public Salesman() {
    }

    public Salesman(String sname, String scity, double scomm) {
        this.sname = sname;
        this.scity = scity;
        this.scomm = scomm;
    }

    public List<Sales> getSales() {
        return sales;
    }

    public void setSales(List<Sales> sales) {
        this.sales = sales;
    }

    public int getScode() {
        return scode;
    }

    public void setScode(int scode) {
        this.scode = scode;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getScity() {
        return scity;
    }

    public void setScity(String scity) {
        this.scity = scity;
    }

    public double getScomm() {
        return scomm;
    }

    public void setScomm(double scomm) {
        this.scomm = scomm;
    }

    public List<Family> getMembers() {
        return members;
    }

    public void setMembers(List<Family> members) {
        this.members = members;
    }

    public void addMember(Family member) {
        if (members == null) {
            members = new ArrayList<>();
        }
        member.setSalesman(this);
        members.add(member);
    }

    public boolean salesmanHasAFamily() {
        boolean answer = false;
        try {
            if (this.getMembers().size() > 0) {
                answer = true;
            }
        } catch (LazyInitializationException ex) {
            answer = false;
        }

        return (answer);

    }

}
