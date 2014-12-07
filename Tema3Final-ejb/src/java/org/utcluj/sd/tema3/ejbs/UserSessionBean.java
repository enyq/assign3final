/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utcluj.sd.tema3.ejbs;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.utcluj.sd.tema3.entities.Users;

/**
 *
 * @author Eniko
 */
@Stateless
@LocalBean
public class UserSessionBean {
    @PersistenceContext(unitName = "Tema3Final-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<Users> retrieve() {
        Query query = em.createNamedQuery("Users.findAll");
        return query.getResultList();
    }

    public Users login(String username, String password) {
         Query query = em.createNamedQuery("Users.findByUsername").setParameter("username", username);
        List<Users> result = query.getResultList();
        if(!result.isEmpty()) {
            Users user = result.get(0);
                if(password.equals(user.getPassword())) {
                    return user;
            }
        }
        return null; 
    }

    
}
