package com.bartlap.stock.wallet.model;

import com.bartlap.stock.loginpage.model.User;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "wallet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wallet.findAll", query = "SELECT w FROM Wallet w")
    , @NamedQuery(name = "Wallet.findById", query = "SELECT w FROM Wallet w WHERE w.id = :id")
    , @NamedQuery(name = "Wallet.findByQuantity", query = "SELECT w FROM Wallet w WHERE w.quantity = :quantity")})
public class Wallet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "quantity")
    private Integer quantity;
    @JoinColumn(name = "stockname", referencedColumnName = "stockname")
    @ManyToOne
    private Market stockname;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user;

    public Wallet() {
    }

    public Wallet(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Market getStockname() {
        return stockname;
    }

    public void setStockname(Market stockname) {
        this.stockname = stockname;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wallet)) {
            return false;
        }
        Wallet other = (Wallet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bartlap.stock.wallet.model.Wallet[ id=" + id + " ]";
    }
    
}
