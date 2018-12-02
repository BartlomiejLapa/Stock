/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bartlap.stock.wallet.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "market")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Market.findAll", query = "SELECT m FROM Market m")
    , @NamedQuery(name = "Market.findByStockname", query = "SELECT m FROM Market m WHERE m.stockname = :stockname")
    , @NamedQuery(name = "Market.findByQuantity", query = "SELECT m FROM Market m WHERE m.quantity = :quantity")})
public class Market implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "stockname")
    private String stockname;
    @Column(name = "quantity")
    private Integer quantity;
    @OneToMany(mappedBy = "stockname")
    private Set<Wallet> walletSet;

    public Market() {
    }

    public Market(String stockname) {
        this.stockname = stockname;
    }

    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname = stockname;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @XmlTransient
    public Set<Wallet> getWalletSet() {
        return walletSet;
    }

    public void setWalletSet(Set<Wallet> walletSet) {
        this.walletSet = walletSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stockname != null ? stockname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Market)) {
            return false;
        }
        Market other = (Market) object;
        if ((this.stockname == null && other.stockname != null) || (this.stockname != null && !this.stockname.equals(other.stockname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bartlap.stock.wallet.model.Market[ stockname=" + stockname + " ]";
    }
    
}
