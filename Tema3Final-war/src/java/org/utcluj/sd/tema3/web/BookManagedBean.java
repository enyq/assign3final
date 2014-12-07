/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utcluj.sd.tema3.web;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.utcluj.sd.tema3.ejbs.BookSessionBean;
import org.utcluj.sd.tema3.entities.Books;

/**
 *
 * @author Eniko
 */
@ManagedBean
@RequestScoped
public class BookManagedBean implements Serializable{
    @EJB
    private BookSessionBean bookSessionBean;
    private Books book;
     private Integer id;
    private String title;
    private String author;
    private Float price;
    private Integer quantity;

    /**
     * Creates a new instance of BookManagedBean
     */
    @PostConstruct
public void init() {
    book = new Books();
}
    public BookManagedBean() {
    }
    
     public List<Books> getBooks()
    {
       return bookSessionBean.retrieve();
    }
     public String delete(Books b) {
        
        bookSessionBean.delete(b);
        return "listBooks";
    }
     
     public String update(Books b) {
    
        this.id = b.getId();
        this.author = b.getAuthor();
        this.title = b.getTitle();
        this.price = b.getPrice();
        this.quantity = b.getQuantity();
        return "updateBook";
    } 

      public String update() {
          book.setId(id);
          book.setAuthor(author);
          book.setTitle(title);
          book.setPrice(price);
          book.setQuantity(quantity);
       bookSessionBean.update(book);
        return "listBooks";
    } 
     public String insert(){
         return "insertBook";
     }
     
     public String persist() {
        
         bookSessionBean.persist(book);
         return "listBooks";
     }
     
   

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }
     
     

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
     
     
}
