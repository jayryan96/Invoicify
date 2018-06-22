package com.el.ally.invoicify.models;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="billingRecords")
public abstract class BillingRecord {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
		
	@ManyToOne
	private Company company;
	
	@JsonManagedReference
	@OneToOne(mappedBy="billingRecord")
	private InvoiceLineItem lineItem;
	
	@ManyToOne
	private User createdBy;
	
	private Date createdOn;
	private String description;
	
	public BillingRecord() {
		long now = Calendar.getInstance().getTimeInMillis();
		createdOn = new Date(now);
	}
	
	public BillingRecord(String description, Company company, User createdBy) {
		this();
		this.description = description;
		this.company = company;
		this.createdBy = createdBy;
	}
	
	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public abstract double getTotal();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public InvoiceLineItem getLineItem() {
		return lineItem;
	}

	public void setLineItem(InvoiceLineItem lineItem) {
		this.lineItem = lineItem;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
