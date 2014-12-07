package org.utcluj.sd.tema3.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.utcluj.sd.tema3.entities.Orders;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-07T22:16:21")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> name;
    public static volatile SingularAttribute<Users, Integer> id;
    public static volatile SingularAttribute<Users, String> type;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile ListAttribute<Users, Orders> ordersList;
    public static volatile SingularAttribute<Users, String> username;

}