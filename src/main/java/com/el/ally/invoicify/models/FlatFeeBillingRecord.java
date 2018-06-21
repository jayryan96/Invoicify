package com.el.ally.invoicify.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="flate_fee_billing_records")
public class FlatFeeBillingRecord extends BillingRecord {

	private double amount;
	
	public FlatFeeBillingRecord() {}
	//default constructor needed to resolve the 404
	
	public FlatFeeBillingRecord(double amount, String description, Company company) {
		super(description, company);
		this.amount = amount;
	}
	
	@Override
	public double getTotal() {
		return amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
