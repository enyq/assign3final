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
import org.utcluj.sd.tema3.ejbs.BookSessionBean;
import org.utcluj.sd.tema3.ejbs.OrderSessionBean;
import org.utcluj.sd.tema3.entities.Books;
import org.utcluj.sd.tema3.entities.Orders;
import org.utcluj.sd.tema3.entities.Users;

/**
 *
 * @author Eniko
 */
@ManagedBean
@SessionScoped
public class OrderManagedBean implements Serializable{
    @EJB
    private OrderSessionBean orderSessionBean;
    @EJB 
    private BookSessionBean bookSessionBean;
    private Orders order;
    private Books book;
    private Users user;
    private Integer quantity;
    private Float price;
    /**
     * Creates a new instance of OrderManagedBean
     */
    public OrderManagedBean() {
    }

    @PostConstruct
    public void init() {
        order = new Orders();
    }
    public String buy() {
        order = new Orders(this.book.getId(), this.user.getId());
        price = book.getPrice();
        order.setPrice(price*quantity);
        order.setQuantity(quantity);
        order.setBooks(this.book);
        order.setUsers(this.user);
        orderSessionBean.persist(order);
        book.setQuantity(book.getQuantity()-quantity);
        bookSessionBean.update(book);
        return "listBooks";
    }
    
      public String buy(Users user,Books book){
         this.book = book;
         this.user = user;
         return "buyBook";
     } 
    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    
    
    
}
