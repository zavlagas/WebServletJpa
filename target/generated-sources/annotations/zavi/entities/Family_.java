package zavi.entities;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import zavi.entities.Salesman;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-15T03:41:40")
@StaticMetamodel(Family.class)
public class Family_ { 

    public static volatile SingularAttribute<Family, Integer> fid;
    public static volatile SingularAttribute<Family, String> fname;
    public static volatile SingularAttribute<Family, LocalDate> dob;
    public static volatile SingularAttribute<Family, String> frelationship;
    public static volatile SingularAttribute<Family, Salesman> salesman;

}