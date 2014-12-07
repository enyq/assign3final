/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utcluj.sd.tema3.mdb;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import org.utcluj.sd.tema3.ejbs.UserSessionBean;
import org.utcluj.sd.tema3.entities.Books;
import org.utcluj.sd.tema3.entities.Users;
import org.utcluj.sd.tema3.mail.SendMail;

/**
 *
 * @author Eniko
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/NotificationQueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class NotificationBean implements MessageListener {
    
    @EJB 
    private UserSessionBean userSessionBean;
    public NotificationBean() {
    }
    
    @Override
    public void onMessage(Message message) {
         SendMail sm = new SendMail();
         try
        {
            Object msgObj = ((ObjectMessage)message).getObject();
            if (msgObj != null)
            {
                Books book = (Books)msgObj;
                System.out.println("Book with the following details has been added:");
                StringBuilder sb = new StringBuilder();
                sb.append("Book ID=");
                sb.append(book.getId());
                sb.append(", ");
                sb.append("Title=");
                sb.append(book.getTitle());
                sb.append(", ");
                sb.append("Author=");
                sb.append(book.getAuthor());
                System.out.println(sb.toString());
                List<Users> users = userSessionBean.retrieve();
                sm.sendMail(book,users);
            }
        }
        catch (JMSException ex)
        {
            Logger.getLogger(NotificationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
