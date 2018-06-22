package com.el.ally.invoicify.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.el.ally.invoicify.models.Company;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="company")
public class Company {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	
	@Column(length=75, nullable=false)
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy="company")
	private List<Invoice> invoices;


	public Company(String name, List<Invoice> invoices) {
		this.name = name;
		this.invoices = invoices;
	}
	
	public Company() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}