/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utcluj.sd.tema3.mail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.utcluj.sd.tema3.entities.Books;
import org.utcluj.sd.tema3.entities.Users;

/**
 *
 * @author Eniko
 */
public class SendMail implements Serializable{
    
   

    public SendMail() {
    }
    
    
    public void sendMail(Books book,List<Users> users){
        
     List<InternetAddress> addr = new ArrayList<>();
      for(Users user: users) {
         try {
             addr.add(new InternetAddress(user.getEmail()));
         } catch (AddressException ex) {
             Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, ex);
         }
      }
    
InternetAddress[] to = new InternetAddress[ addr.size() ];
addr.toArray(to);
      // Sender's email ID needs to be mentioned
      String from = "eniko.antal92@gmail.com";
    
      // Assuming you are sending email through relay.jangosmtp.net
       String host = "smtp.gmail.com";
    String username = "eniko.antal92";
    String password = "charmed**10";
    Properties props = new Properties();
    // set any needed mail.smtps.* properties here
    Session session = Session.getInstance(props);
    MimeMessage msg = new MimeMessage(session);
   
	   
    // set the message content here
    Transport t = null;
          try {
                msg.setFrom(new InternetAddress(from));
                msg.setRecipients(Message.RecipientType.TO,to);
                msg.setSubject("New available book");
		msg.setText("A new book has arrived\n Title: "+ book.getTitle() + "\nAuthor: " + book.getAuthor() + "\nPrice: " + book.getPrice());
                t = session.getTransport("smtps");
                t.connect(host, username, password);
                t.sendMessage(msg, msg.getAllRecipients());
          } catch (NoSuchProviderException ex) {
              Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, ex);
   
    }     catch (MessagingException ex) {
              Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, ex);
          } finally {
          try {
              t.close();
          } catch (MessagingException ex) {
              Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
   
    }
}
