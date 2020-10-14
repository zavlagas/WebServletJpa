package zavi.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import zavi.entities.Sales;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-14T16:36:31")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Integer> pcode;
    public static volatile SingularAttribute<Product, Double> pprice;
    public static volatile SingularAttribute<Product, String> pdescr;
    public static volatile ListAttribute<Product, Sales> sales;

}