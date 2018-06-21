package com.el.ally.invoicify.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="RateBasedBillingRecord")
public class RateBasedBillingRecord extends BillingRecord {
    
    
    private double quantity;
    
    @Column
    private double rate;
    
    public RateBasedBillingRecord() {}
    
    public RateBasedBillingRecord(double quantity, double rate, String description, Company company) {
        super(description, company);
        this.quantity = quantity;
        this.rate = rate;
    }

    @Override
    public double getTotal() {
        return rate*quantity;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }


}

