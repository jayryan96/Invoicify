package com.el.ally.invoicify.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.ally.invoicify.models.Company;
import com.el.ally.invoicify.models.FlatFeeBillingRecord;
import com.el.ally.invoicify.models.User;
import com.el.ally.invoicify.repositories.BillingRecordRepository;
import com.el.ally.invoicify.repositories.CompanyRepository;

@RestController
@RequestMapping("/api/billing-record/flat-fee")
public class FlatFeeBillingRecordController {

	@Autowired
	private BillingRecordRepository recordRepository;
	@Autowired
	private CompanyRepository companyRepository;

	public FlatFeeBillingRecordController(BillingRecordRepository recordRepository, CompanyRepository companyRepository) {
		this.recordRepository = recordRepository;
		this.companyRepository = companyRepository;
	}
	public FlatFeeBillingRecordController() {}
	
	@PostMapping("{companyID}")
	public FlatFeeBillingRecord create(@RequestBody FlatFeeBillingRecord record, @PathVariable int companyID, Authentication auth) {
		
		User user = (User) auth.getPrincipal();
		Company company = companyRepository.findOne(companyID);
		record.setCompany(company);
		record.setCreatedBy(user);
		recordRepository.save(record);
		
		return recordRepository.save(record);
	}

}