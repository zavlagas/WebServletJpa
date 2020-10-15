package zavi.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import zavi.entities.Family;
import zavi.entities.Sales;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-15T16:44:28")
@StaticMetamodel(Salesman.class)
public class Salesman_ { 

    public static volatile SingularAttribute<Salesman, Integer> scode;
    public static volatile SingularAttribute<Salesman, String> sname;
    public static volatile ListAttribute<Salesman, Family> members;
    public static volatile SingularAttribute<Salesman, Double> scomm;
    public static volatile SingularAttribute<Salesman, String> scity;
    public static volatile ListAttribute<Salesman, Sales> sales;

}