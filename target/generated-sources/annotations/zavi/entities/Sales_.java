package zavi.entities;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import zavi.entities.Customer;
import zavi.entities.Product;
import zavi.entities.Salesman;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-15T13:54:15")
@StaticMetamodel(Sales.class)
public class Sales_ { 

    public static volatile SingularAttribute<Sales, LocalDate> sdate;
    public static volatile SingularAttribute<Sales, Product> product;
    public static volatile SingularAttribute<Sales, Integer> scode;
    public static volatile SingularAttribute<Sales, Double> cost;
    public static volatile SingularAttribute<Sales, Salesman> salesman;
    public static volatile SingularAttribute<Sales, Integer> quant;
    public static volatile SingularAttribute<Sales, Customer> customer;

}