package com.el.ally.invoicify.models;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.el.ally.invoicify.models.Company;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="invoices")
public class Invoice {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
		
	@ManyToOne
	private Company company;
	
	private Date createdOn;
	private String invoiceDescription;
	
	@ManyToOne
	private User createdBy;
	
	@JsonManagedReference(value="secondParent")
	@OneToMany(mappedBy="invoice", cascade=CascadeType.ALL)
	private List<InvoiceLineItem> lineItems;

	
	public Invoice(Company company, Date createdOn, String invoiceDescription, User createdBy) {
		this.createdBy = createdBy;
		this.company = company;
		this.createdOn = createdOn;
		this.invoiceDescription = invoiceDescription;
	}


	public User getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Invoice() {
		long now = Calendar.getInstance().getTimeInMillis();
		createdOn = new Date(now);
	}

	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public Date getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}


	public String getInvoiceDescription() {
		return invoiceDescription;
	}


	public void setInvoiceDescription(String invoiceDescription) {
		this.invoiceDescription = invoiceDescription;
	}


	public List<InvoiceLineItem> getLineItems() {
		return lineItems;
	}


	public void setLineItems(List<InvoiceLineItem> lineItems) {
		this.lineItems = lineItems;
	}


	public int getId() {
		return id;
	}
	
}
