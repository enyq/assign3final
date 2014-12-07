package org.utcluj.sd.tema3.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.utcluj.sd.tema3.entities.Orders;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-07T22:16:21")
@StaticMetamodel(Books.class)
public class Books_ { 

    public static volatile SingularAttribute<Books, Integer> quantity;
    public static volatile SingularAttribute<Books, String> author;
    public static volatile SingularAttribute<Books, Float> price;
    public static volatile SingularAttribute<Books, Integer> id;
    public static volatile SingularAttribute<Books, String> title;
    public static volatile ListAttribute<Books, Orders> ordersList;

}