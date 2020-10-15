/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zavi.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Family implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//DB will create the primary key (auto increment)
    private int fid;
    private String fname;
    private String frelationship;
    private Date dob;
    @ManyToOne
    @JoinColumn(name = "salesman")//owing side
    private Salesman salesman;

    public Family() {
    }

    public Family(String fname, String frelationship, Date dob) {
        this.fname = fname;
        this.frelationship = frelationship;
        this.dob = dob;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFrelationship() {
        return frelationship;
    }

    public void setFrelationship(String frelationship) {
        this.frelationship = frelationship;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

}
