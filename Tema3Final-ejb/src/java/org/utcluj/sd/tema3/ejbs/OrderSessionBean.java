/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utcluj.sd.tema3.ejbs;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Eniko
 */
@Stateless
@LocalBean
public class OrderSessionBean {
    @PersistenceContext(unitName = "Tema3Final-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

   
}
