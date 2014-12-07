/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utcluj.sd.tema3.web;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.utcluj.sd.tema3.ejbs.UserSessionBean;
import org.utcluj.sd.tema3.entities.Users;

/**
 *
 * @author Eniko
 */
@ManagedBean
@SessionScoped
public class UserManagedBean implements Serializable{

     @EJB
    private UserSessionBean userSessionBean;
    private Users user;
    private int id;
    private String name;
    private String username;
    private String password;
    private String usertype;
    private String email;
  
    /**
     * Creates a new instance of UserManagedBean
     */
    public UserManagedBean() {
    }

    @PostConstruct
    public void init() {
        user = new Users();
    }
    public String login() {
        user = userSessionBean.login(username, password);
        if(user!=null)
        {
 
        
                if (user.getType().equals("admin")) {
                    setUsertype("admin");
                    System.out.println("Login as admin");
                return "listBooks";
                } else { 
                    setUsertype("simple");
                     System.out.println("Login as simple");
                return "listBooks"; 
                }
                
        } else {
                return "listBooks";
            }
        
    }
    
   public String register() {
       return "registerUser";
   }
   
   public String registerUser() {
       user.setType("simple");
       userSessionBean.persist(user);
       return "listBooks";
   }
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
