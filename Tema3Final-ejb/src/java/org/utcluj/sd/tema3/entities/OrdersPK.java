/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utcluj.sd.tema3.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Eniko
 */
@Embeddable
public class OrdersPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "BOOKID")
    private int bookid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USERID")
    private int userid;

    public OrdersPK() {
    }

    public OrdersPK(int bookid, int userid) {
        this.bookid = bookid;
        this.userid = userid;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) bookid;
        hash += (int) userid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdersPK)) {
            return false;
        }
        OrdersPK other = (OrdersPK) object;
        if (this.bookid != other.bookid) {
            return false;
        }
        if (this.userid != other.userid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.utcluj.sd.tema3.entities.OrdersPK[ bookid=" + bookid + ", userid=" + userid + " ]";
    }
    
}
