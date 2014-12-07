/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utcluj.sd.tema3.ejbs;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.utcluj.sd.tema3.entities.Books;

/**
 *
 * @author Eniko
 */
@Stateless
@LocalBean
public class BookSessionBean {
    @Resource(mappedName = "jms/NotificationQueue")
    private Queue notificationQueue;
    @Inject
    @JMSConnectionFactory("jms/NotificationQueueFactory")
    private JMSContext context;
   
  
    @PersistenceContext(unitName = "Tema3Final-ejbPU")
    private EntityManager em;

    public void persist(Books book) {
        em.persist(book);
         try
        {
            sendJMSMessageToNotificationQueue(book);
        }
        catch (JMSException ex)
       {
            Logger.getLogger(BookSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Books added in BookSessionBean!");
        
    }

    public List<Books> retrieve() {
         Query query = em.createNamedQuery("Books.findAll");
      return query.getResultList();
  }

    public void delete(Books b) {
        em.remove(em.merge(b));
        }
    
    public Books update(Books b) {
       Books updated = em.merge(b);
       
        return updated;
    }

    private void sendJMSMessageToNotificationQueue(Books messageData) throws JMSException{
        context.createProducer().send(notificationQueue, messageData);
    }

   

   
}
