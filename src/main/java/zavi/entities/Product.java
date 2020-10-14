/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zavi.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//DB will create the primary key (auto increment)
    private int pcode;
    private String pdescr;
    private double pprice;
    @OneToMany(mappedBy = "product")
    private List<Sales> sales;

    public Product() {
    }

    public Product(String pdescr, double pprice) {
        this.pdescr = pdescr;
        this.pprice = pprice;
    }

    public List<Sales> getSales() {
        return sales;
    }

    public void setSales(List<Sales> sales) {
        this.sales = sales;
    }

    public int getPcode() {
        return pcode;
    }

    public void setPcode(int pcode) {
        this.pcode = pcode;
    }

    public String getPdescr() {
        return pdescr;
    }

    public void setPdescr(String pdescr) {
        this.pdescr = pdescr;
    }

    public double getPprice() {
        return pprice;
    }

    public void setPprice(double pprice) {
        this.pprice = pprice;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.pcode;
        hash = 17 * hash + Objects.hashCode(this.pdescr);
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.pprice) ^ (Double.doubleToLongBits(this.pprice) >>> 32));
        hash = 17 * hash + Objects.hashCode(this.sales);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (this.pcode != other.pcode) {
            return false;
        }
        if (Double.doubleToLongBits(this.pprice) != Double.doubleToLongBits(other.pprice)) {
            return false;
        }
        if (!Objects.equals(this.pdescr, other.pdescr)) {
            return false;
        }
        if (!Objects.equals(this.sales, other.sales)) {
            return false;
        }
        return true;
    }

    

    

    

}
