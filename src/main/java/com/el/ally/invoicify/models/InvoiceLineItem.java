package com.el.ally.invoicify.models;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class InvoiceLineItem {

 
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

	@JsonBackReference
    @OneToOne
    private BillingRecord billingRecord;
    
    private Date createdOn;

    @JsonBackReference(value ="secondParent")
    @ManyToOne
    private Invoice invoice;    
    
    @ManyToOne
	private User createdBy;
    
    public InvoiceLineItem(BillingRecord billingRecord, Date createdOn, Invoice invoice, User createdBy) {
    	this.createdBy = createdBy;
		this.billingRecord = billingRecord;
		this.createdOn = createdOn;
		this.invoice = invoice;
	}
    public User getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	public InvoiceLineItem() {}
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BillingRecord getBillingRecord() {
        return billingRecord;
    }

    public void setBillingRecord(BillingRecord billingRecord) {
        this.billingRecord = billingRecord;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}