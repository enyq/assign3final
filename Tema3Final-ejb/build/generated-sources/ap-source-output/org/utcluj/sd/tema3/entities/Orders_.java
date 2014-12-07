package org.utcluj.sd.tema3.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.utcluj.sd.tema3.entities.Books;
import org.utcluj.sd.tema3.entities.OrdersPK;
import org.utcluj.sd.tema3.entities.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-07T22:16:21")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, OrdersPK> ordersPK;
    public static volatile SingularAttribute<Orders, Integer> quantity;
    public static volatile SingularAttribute<Orders, Books> books;
    public static volatile SingularAttribute<Orders, Float> price;
    public static volatile SingularAttribute<Orders, Users> users;

}