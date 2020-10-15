package zavi.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import zavi.entities.Sales;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-15T16:44:28")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, Integer> ccode;
    public static volatile SingularAttribute<Customer, String> cname;
    public static volatile ListAttribute<Customer, Sales> sales;

}